package online.shop.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.shop.domain.Enum.Gender;
import online.shop.domain.Enum.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "student_id")
    private Long id;
    private String name;
    private int dataOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String department;
    private int phoneNum;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String name, int dataOfBirth, Gender gender, String department, int phoneNum, String email){
        this.name = name;
        this.dataOfBirth = dataOfBirth;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.email = email;
        this.role = Role.NORMAL;
    }

    //마스터 권한 부여
    public void makeMaster(){
        this.setRole(Role.MASTER);
    }
}
