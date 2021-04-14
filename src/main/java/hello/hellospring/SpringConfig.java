package hello.hellospring;

import hello.hellospring.repository.MemberResository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
자바코드로 스프링빈을 등록
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberResository());
    }

    @Bean
    public MemberResository memberResository(){
        return new MemoryMemberRepository();
    }
}
