package jjun.core;

import jjun.core.discount.DiscountPolicy;
import jjun.core.discount.FixDiscountPolicy;
import jjun.core.discount.RateDiscountPolicy;
import jjun.core.member.MemberRepository;
import jjun.core.member.MemberService;
import jjun.core.member.MemberServiceImpl;
import jjun.core.member.MemoryMemberRepository;
import jjun.core.order.OrderService;
import jjun.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
