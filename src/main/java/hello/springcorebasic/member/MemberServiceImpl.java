package hello.springcorebasic.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; // 생성자 주입할 때에는 final 필요

    // 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member){
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
