package com.example.basic;

import com.example.basic.member.Grade;
import com.example.basic.member.Member;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;

public class MemberApp {
  // Without Spring Test
  // 이거는 매우 간단한 테스트 코드이다. 실제로는 JUnit 같은 테스트 프레임워크를 사용해야 한다.
  public static void main(String[] args){
    MemberService memberService = new MemberServiceImpl();
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("find member = " + findMember.getName());
  }
}
