package hello.springcorebasic.member;

import hello.springcorebasic.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
