package online.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.shop.domain.Club;
import online.shop.domain.Enum.ClubType;
import online.shop.domain.Enum.Gender;
import online.shop.domain.Enum.Role;
import online.shop.domain.Member;
import online.shop.persistence.SpringDataClubRepository;
import online.shop.persistence.SpringDataMemberRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class initData {
    private final InitService initService;
    @EventListener(ApplicationReadyEvent.class)
    public void initData() throws IOException {
        log.info("데이터 초기화 시작");
        initService.init();
    }
    @Component
    @RequiredArgsConstructor
    @Transactional
    public static class InitService {
        private final SpringDataMemberRepository memberRepository;
        private final SpringDataClubRepository clubRepository;

        public void init() throws IOException {
            initMember();
            initClub();
            //initClubInfo();
            //initClubMember();
            //initPost();
        }

        private void initMember(){
            initMember("kim", 20000908, Gender.MALE, "computer software engineering",
                    "010-1234-5678","20190826@kumoh.ac.kr", Role.NORMAL);
            initMember("lee1", 20001111, Gender.MALE, "Electronic Engineering",
                    "010-7676-5432","7676@naver.com", Role.NORMAL);
            initMember("pro1", 20001112, Gender.FEMALE, "computer software engineering",
                    "010-2623-5432","2623@naver.com", Role.PROFESSOR);
            initMember("pro2", 20001113, Gender.MALE, "Electronic Engineering",
                    "010-9876-5432","9876@naver.com", Role.PROFESSOR);
            initMember("bak", 20001114, Gender.FEMALE, "computer software engineering",
                    "010-1243-5678","1243@naver.com\"", Role.NORMAL);
            initMember("beak", 20001115, Gender.MALE, "computer software engineering",
                    "010-1235-5678","1235@naver.com\"", Role.NORMAL);
            initMember("beak", 20001116, Gender.FEMALE, "computer software engineering",
                    "010-1263-5678","1263@naver.com\"", Role.NORMAL);
        }

        private void initMember(String name, int dataOfBirth, Gender gender, String department, String phoneNum, String email, Role role    ){
            Member member = Member.builder()
                    .name(name)
                    .dataOfBirth(dataOfBirth)
                    .gender(gender)
                    .department(department)
                    .phoneNum(phoneNum)
                    .email(email)
                    .role(role)
                    .build();
            memberRepository.save(member);
        }


        private void initClub(){
            Member lee1 = memberRepository.findFirstByName("lee1");
            Member kim = memberRepository.findFirstByName("kim");
            Member pro1 = memberRepository.findFirstByName("pro1");
            Member pro2 = memberRepository.findFirstByName("pro2");
            initClub("AClub",ClubType.CENTRAL,lee1, pro1);
            initClub("BClub",ClubType.DEPARTMENT,kim,pro2);

        }

        private void initClub(String name, ClubType clubType, Member reqStudent, Member reqProfessor){
            Club club = Club.builder()
                    .name(name)
                    .clubType(clubType)
                    .reqStudent(reqStudent)
                    .reqProfessor(reqProfessor)
                    .build();
            clubRepository.save(club);
        }

    }
}
