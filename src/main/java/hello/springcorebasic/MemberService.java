package hello.springcorebasic;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
