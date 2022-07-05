package jjun.core;

import jjun.core.member.Grade;
import jjun.core.member.Member;
import jjun.core.member.MemberService;
import jjun.core.member.MemberServiceImpl;
import jjun.core.order.Order;
import jjun.core.order.OrderService;
import jjun.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
