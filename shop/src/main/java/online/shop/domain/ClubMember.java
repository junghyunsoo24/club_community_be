package online.shop.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.shop.domain.Enum.Condition;
import online.shop.domain.Enum.Rank;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClubMember {
    @EmbeddedId
    private ClubMemberId id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Member student;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Rank rank;

}
