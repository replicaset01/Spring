package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 회원가입 생성
    public Long join(Member member) {
        // null이 아닌 어떤 값이 있으면 이 로직 동작
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // 통과하면 저장
        return member.getId();  // ID 반환
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { // OptionalMember. 이 생략되어 있음
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 모든 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}