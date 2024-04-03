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

public class AppConfig { // 공연 기획자
    public MemberService memberService(){ // 역할
        return new MemberServiceImpl(memberRepository()); // 구현
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    public DiscountPolicy discountPolicy(){
//        return new FixDoiscountPolicy();
        return new RateDiscountPolicy();
    }
    // 역할과 구현이 한눈에 들어옴. Fix -> Rate 등으로 쉽게 구체 객체를 바꿀 수 있음.

}
