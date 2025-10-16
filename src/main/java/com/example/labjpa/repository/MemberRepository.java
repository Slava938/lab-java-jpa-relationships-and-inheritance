package com.example.labjpa.repository;
import com.example.labjpa.entity.association.Member;
import com.example.labjpa.entity.association.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByStatus(MemberStatus status);
}
