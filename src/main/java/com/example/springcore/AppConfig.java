package com.example.springcore;

import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.discount.FixDiscountPolicy;
import com.example.springcore.member.MemberRepository;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;
import com.example.springcore.member.MemoryMemberRepository;
import com.example.springcore.order.OrderService;
import com.example.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        return new FixDiscountPolicy();
    }

}
