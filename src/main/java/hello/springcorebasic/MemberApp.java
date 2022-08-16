package hello.springcorebasic;

import hello.springcorebasic.member.*;

public class MemberApp {

    public static void main(String[] args) {

        /*
        회원 가입, 회원조회 테스트
         */
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "member1", Grade.VIP);
        memberService.join(member);

        Member findMember1 = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember1.getName());
    }
}
