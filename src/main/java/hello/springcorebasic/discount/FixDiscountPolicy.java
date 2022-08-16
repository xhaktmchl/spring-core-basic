package hello.springcorebasic.discount;

import hello.springcorebasic.member.Grade;
import hello.springcorebasic.member.Member;

// 할인 구현체
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    // vip면 1000원 할인, 아니면 할인 없음
    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        else{
            return 0;
        }
    }
}
