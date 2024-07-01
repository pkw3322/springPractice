package com.example.basic.discount;

import com.example.basic.member.Member;

public interface DiscountPolicy {

      int discount(Member member, int price);

}
