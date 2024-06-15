package online.shop.service;

import online.shop.domain.Enum.Gender;
import online.shop.domain.Enum.Role;
import online.shop.domain.Member;
import online.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member joinMember(String name, int dataOfBirth, Gender gender, String department,
                             String phoneNum, String email) {
        Member member = Member.builder()
                .name(name)
                .dataOfBirth(dataOfBirth)
                .gender(gender)
                .department(department)
                .phoneNum(phoneNum)
                .email(email)
                .role(Role.NORMAL)
                .build();
        return memberRepository.save(member);
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
