package jjun.core;

import jjun.core.discount.DiscountPolicy;
import jjun.core.member.MemberRepository;
import jjun.core.member.MemoryMemberRepository;
import jjun.core.order.OrderService;
import jjun.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(   // 컴포넌트 스캔 사용
        // basePackages = "jjun.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes=Configuration.class)
)
public class AutoAppConfig {

    /*@Autowired MemberRepository memberRepository;
    @Autowired DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService() {
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/

}
