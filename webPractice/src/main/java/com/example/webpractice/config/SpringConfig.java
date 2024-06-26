package com.example.webpractice.config;

import com.example.webpractice.repository.MemberRepository;
import com.example.webpractice.repository.MemoryMemberRepository;
import com.example.webpractice.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }
  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}