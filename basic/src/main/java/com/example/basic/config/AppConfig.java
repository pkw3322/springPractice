package com.example.basic.config;

import com.example.basic.discount.DiscountPolicy;
import com.example.basic.discount.FixDiscountPolicy;
import com.example.basic.discount.RateDiscountPolicy;
import com.example.basic.member.MemberRepository;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import com.example.basic.member.MemoryMemberRepository;
import com.example.basic.order.OrderService;
import com.example.basic.order.OrderServiceImpl;

public class AppConfig {
  //DIP, OCP 규칙 준수 repository 바꾼다면 memberRepository() 만 수정하면 된다.

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  private MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  private DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
    // To change discount policy, only this line needs to be changed.
    return new RateDiscountPolicy();
  }
}
