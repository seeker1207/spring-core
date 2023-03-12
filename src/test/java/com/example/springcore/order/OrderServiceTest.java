package com.example.springcore.order;

import com.example.springcore.AppConfig;
import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(1L, "손지훈", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "최신형 컴퓨터", 45000);

        assertEquals(1000, order.getDiscount());

    }


}