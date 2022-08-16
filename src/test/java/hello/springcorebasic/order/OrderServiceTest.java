package hello.springcorebasic.order;

import hello.springcorebasic.AppConfig;
import hello.springcorebasic.member.Grade;
import hello.springcorebasic.member.Member;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        // 생성자 주입으로 서비스 객체들 생성
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        //주문
        Order order = orderService.createOrder(memberId, "item1", 10000);
        System.out.println("order = " + order);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}