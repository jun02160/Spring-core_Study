package jjun.core.member;

public interface MemberService {

    void join(Member member);   // 회원 가입
    
    Member findMember(Long memberID);  // 회원 조회
}
