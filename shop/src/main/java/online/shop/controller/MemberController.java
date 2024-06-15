package online.shop.controller;

import jakarta.servlet.http.HttpSession;
import online.shop.domain.Enum.Gender;
import online.shop.domain.Member;
import online.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/join")
    public String showJoinForm() {
        return "login/join";
    }

    @PostMapping("/join")
    public String joinMember(@RequestParam String name,
                             @RequestParam int dataOfBirth,
                             @RequestParam Gender gender,
                             @RequestParam String department,
                             @RequestParam String phoneNum,
                             @RequestParam String email,
                             HttpSession session) {
        Member member = memberService.joinMember(name, dataOfBirth, gender, department, phoneNum, email);
        session.setAttribute("memberId", member.getId());
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String showMembers(Model model, HttpSession session) {
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            return "redirect:/join";
        }
        Member member = memberService.getMemberById(memberId);
        model.addAttribute("member", member);
        return "login/members";
    }
}