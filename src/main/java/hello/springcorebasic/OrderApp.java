package hello.springcorebasic;

import hello.springcorebasic.member.Grade;
import hello.springcorebasic.member.Member;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;
import hello.springcorebasic.order.Order;
import hello.springcorebasic.order.OrderService;
import hello.springcorebasic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        // 생성자 주입으로 서비스 객체들 생성
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        //주문
        Order order = orderService.createOrder(memberId, "item1", 10000);
        System.out.println("order = " + order);
    }
}
