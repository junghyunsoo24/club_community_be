package online.shop.domain;

import jakarta.persistence.*;
import lombok.*;
import online.shop.domain.Enum.BoardType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    private String title;
    private String context;
    private String url;

    @Builder
    public Post(Member member, BoardType boardType,
                String title, String context, String url){
        this.member = member;
        this.boardType = boardType;
        this.title = title;
        this.context = context;
        this.url = url;
    }
}

// 연관관계 설정 완료
// 빌더 완료