package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    @Bean // 스프링 빈에 등록하라는 어노테이션
    public MemberService memberService() {
        return new MemberService(memberRepository());
        // 스프링빈에 멤버레포를 추가하고 ↓, 멤버서비스에 넣어줌
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();


    }
}
