package hello.springcorebasic.order;

import hello.springcorebasic.discount.DiscountPolicy;
import hello.springcorebasic.member.Member;
import hello.springcorebasic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 주문 서비스 구현체
@Component
@RequiredArgsConstructor // final 붙은 필드에 생성자 자동 생성 및 주입
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자 주입
//    @Autowired // @Autowired 를 사용하면 생성자에서 여러 의존관계도 한번에 주입받을 수 있다
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        // 멤버 조회
        Member member = memberRepository.findById(memberId);
        // 할인정책 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 주문 생성
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
