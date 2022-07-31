package spring.security.JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.JWT.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByUsername(String member);
}
