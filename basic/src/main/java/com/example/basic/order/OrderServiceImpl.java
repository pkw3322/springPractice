package com.example.basic.order;

import com.example.basic.discount.DiscountPolicy;
import com.example.basic.member.Member;
import com.example.basic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }
  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    // 확장 정책 잘 반영 된 예시. discount logic 변경되면 discount policy 만 수정하면 된다.
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
