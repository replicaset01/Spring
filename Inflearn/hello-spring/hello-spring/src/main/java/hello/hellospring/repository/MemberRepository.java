package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);                 // save 기능

    Optional<Member> findById(long id);         // id로 회원 검색

    Optional<Member> findByName(String name);   // 이름으로 회원 검색

    List<Member> findAll();                     // 모든 회원 리스트 반환
}
