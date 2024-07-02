package com.example.basic.order;

import com.example.basic.discount.DiscountPolicy;
import com.example.basic.discount.FixDiscountPolicy;
import com.example.basic.discount.RateDiscountPolicy;
import com.example.basic.member.Member;
import com.example.basic.member.MemberRepository;
import com.example.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  // DIP 위반. FixDiscountPolicy 에 의존하고 있다. 추상화에 의존하도록 수정해야 한다.
//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    // 확장 정책 잘 반영 된 예시. discount logic 변경되면 discount policy 만 수정하면 된다.
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
