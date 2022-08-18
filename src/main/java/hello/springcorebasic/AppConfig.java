package hello.springcorebasic;

import hello.springcorebasic.discount.DiscountPolicy;
import hello.springcorebasic.discount.FixDiscountPolicy;
import hello.springcorebasic.discount.RateDiscountPolicy;
import hello.springcorebasic.member.MemberRepository;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;
import hello.springcorebasic.member.MemoryMemberRepository;
import hello.springcorebasic.order.OrderService;
import hello.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정정보임을 명시
public class AppConfig {

    @Bean // 스프링 컨테이너에 스프링 빈으로 등록
    public MemberService memberService() {
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean// 스프링 컨테이너에 스프링 빈으로 등록
    public OrderService orderService() {
        //1번
        System.out.println("call AppConfig.orderService");

        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean// 스프링 컨테이너에 스프링 빈으로 등록
    public MemberRepository memberRepository(){

        //2번? 3번?
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean// 스프링 컨테이너에 스프링 빈으로 등록
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // 할인정책을 바꿀 때 Appconfig만 설정 -> OCP, DIP원칙 지켜짐
    }
}
