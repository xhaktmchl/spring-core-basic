package hello.springcorebasic;

public interface MemberRepository {

    void save(Member member); // 회원가입

    Member findById(Long id); // 회원 조회
}
