package online.shop.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.shop.domain.Enum.ClubApprovalStatus;
import online.shop.domain.Enum.ClubType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Club {

    @Id @GeneratedValue
    @Column(name = "club_id")
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "club_type")
    private ClubType clubType;

    @ManyToOne
    @JoinColumn(name = "request_student_id", referencedColumnName = "student_id")
    private Member reqStudent;

    @ManyToOne
    @JoinColumn(name = "request_professor_id", referencedColumnName = "student_id")
    private Member reqProfessor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ClubApprovalStatus status;

    private String refuseInfo;

    @Builder
    public Club(String name, ClubType clubType, Member reqStudent, Member reqProfessor)
    {
        this.name = name;
        this.clubType = clubType;
        this.reqStudent = reqStudent;
        this.reqProfessor = reqProfessor;
        this.status = ClubApprovalStatus.WAITING;
    }

    public void refuse(String refuseInfo){
        this.refuseInfo = refuseInfo;
        this.status = ClubApprovalStatus.REFUSE;
    }
    public void approval(){
        this.status = ClubApprovalStatus.ACTIVE;
    }
}
