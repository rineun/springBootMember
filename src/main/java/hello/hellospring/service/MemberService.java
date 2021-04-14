package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberResository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
/*
* comand shift T 테스트코드 작성
*
*/
public class MemberService {
    private final MemberResository memberResository;

    public MemberService(MemberResository memberResository) {
        this.memberResository = memberResository;
    }

    /**
     *
     * 회원가
     * @return
     *  command + option+ v
     *  control +t 함수로 빼
     */
    public Long join(Member member){
        //같은 이름 있는 중복 회원  X
        validateDuplicateMember(member);
        memberResository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberResository.findByName(member.getName())
           .ifPresent(m->{
               throw new IllegalStateException("이미 존재하는 회원입니다.");
           });
    }

    /**
     * 전체회원조
     * @return
     */
    public List<Member> findMembers(){
        return memberResository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberResository.findById(memberId);
    }

}
