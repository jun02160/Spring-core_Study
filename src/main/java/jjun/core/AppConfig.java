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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
