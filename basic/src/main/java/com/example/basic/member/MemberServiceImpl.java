package com.example.basic.member;

public class MemberServiceImpl implements MemberService{

  // DIP, OCP 위반
  // new MemoryMemberRepository()를 직접 호출하고 있다.
  private final MemberRepository memberRepository = new MemoryMemberRepository();

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
