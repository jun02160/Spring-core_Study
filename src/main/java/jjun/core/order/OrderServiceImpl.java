package jjun.core.order;

import jjun.core.discount.DiscountPolicy;
import jjun.core.discount.FixDiscountPolicy;
import jjun.core.discount.RateDiscountPolicy;
import jjun.core.member.Member;
import jjun.core.member.MemberRepository;
import jjun.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy;   // 구체화가 아닌 추상화(인터페이스)에 의존하도록

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    /*
    setter 주입: 수정자 주입 방식 -> 선택적 의존 관계 주입 가능
    */
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;   // 구체화가 아닌 추상화(인터페이스)에 의존하도록

    @Autowired(required = false)
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    /*
    생성자 주입
    */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("OrderServiceImpl Constructor called");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    /*
    Field 주입
    */
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;


    /*
    일반 메서드 주입 -> 한 번에 여러 필드 주입 가능 (in 스프링 빈)
    */
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
