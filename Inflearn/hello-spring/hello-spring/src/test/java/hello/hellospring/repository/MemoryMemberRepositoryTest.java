package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { // CallBack Method
        repository.clearStore();
    }

    @Test
    public void save() { // save 기능 동작 테스트
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        // 반환타입이 optional이고 꺼낼때는 get을 써서 꺼냄
        Member result = repository.findById(member.getId()).get();
        // 검증, new에서 꺼낸것과 get으로 꺼낸것이 똑같을때
        // System.out.println("reslut = " + (result == member));
        // Assertions.assertEquals(member, result); <- junitAss
        // ↓ assertjAss  member가 result와 똑같을때
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() { // findByName 동작 테스트
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
