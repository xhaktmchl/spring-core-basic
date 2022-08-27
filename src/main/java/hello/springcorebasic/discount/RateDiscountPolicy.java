package hello.springcorebasic.discount;

import hello.springcorebasic.annotation.MainDiscountPolicy;
import hello.springcorebasic.member.Grade;
import hello.springcorebasic.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // 직접 만든 어노테이션 적용.
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10; //10% 할인

    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP){
            return price*discountPercent/100;
        }
        else{
            return 0;
        }
    }


}
