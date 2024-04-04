package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDoiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 공연 기획자
    @Bean
    public MemberService memberService(){ // 역할
        return new MemberServiceImpl(memberRepository()); // 구현
    }
    @Bean
    public MemberRepository memberRepository() { //역할 (interface)
        return new MemoryMemberRepository(); // 구현 (class)
    }
    @Bean
    public OrderService orderService(){ //역할
        return new OrderServiceImpl( //구현
                memberRepository(),
                discountPolicy()
        );
    }
    @Bean
    public DiscountPolicy discountPolicy(){ //역할
//        return new FixDoiscountPolicy(); //구현
        return new RateDiscountPolicy(); //구현
    }
    // 역할과 구현이 한눈에 들어옴. Fix -> Rate 등으로 쉽게 구체 객체를 바꿀 수 있음.

}
