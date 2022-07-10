package jjun.core.discount;

import jjun.core.annotation.MainDiscountPolicy;
import jjun.core.member.Grade;
import jjun.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary   // 빈 조회 시 우선순위 최상위로 -> 의존관계 주입 우선시
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
