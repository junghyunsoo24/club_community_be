package online.shop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ClubInfo {
    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Club club;
    //private String history;
    private String image;
    private String meetingTime;
    private String requestForm; //추후 파일로 바뀔 예정
}

// 연관관계 설정 완료
// 빌더 아직