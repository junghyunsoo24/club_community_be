package online.shop.persistence;

import online.shop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataMemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByName(String Name); //쿼리 메소드
    Member findFirstByName(String Name);
}
