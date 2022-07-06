package jjun.core;

import jjun.core.discount.FixDiscountPolicy;
import jjun.core.member.MemberService;
import jjun.core.member.MemberServiceImpl;
import jjun.core.member.MemoryMemberRepository;
import jjun.core.order.OrderService;
import jjun.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
