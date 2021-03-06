package jjun.core.scan;

import jjun.core.AutoAppConfig;
import jjun.core.member.MemberRepository;
import jjun.core.member.MemberService;
import jjun.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.AnnotatedParameterizedType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

//        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
//        MemberRepository memberRepository = bean.getMemberRepository();
//        System.out.println("memberRepository = " + memberRepository);
    }
}
