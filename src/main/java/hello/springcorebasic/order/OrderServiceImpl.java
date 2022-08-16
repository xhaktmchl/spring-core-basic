package hello.springcorebasic.order;

import hello.springcorebasic.discount.DiscountPolicy;
import hello.springcorebasic.discount.FixDiscountPolicy;
import hello.springcorebasic.discount.RateDiscountPolicy;
import hello.springcorebasic.member.Member;
import hello.springcorebasic.member.MemberRepository;
import hello.springcorebasic.member.MemoryMemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 율 할인 정책 구현체

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        // 멤버 조회
        Member member = memberRepository.findById(memberId);
        // 할인정책 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 주문 생성
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
