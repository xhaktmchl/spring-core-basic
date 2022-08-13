package hello.springcorebasic.member;

import hello.springcorebasic.member.Member;

public interface MemberRepository {

    void save(Member member); // 회원가입

    Member findById(Long id); // 회원 조회
}
