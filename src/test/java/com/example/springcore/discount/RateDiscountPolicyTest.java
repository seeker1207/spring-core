package com.example.springcore.discount;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용 되어야 한다.")
    void vipDiscount() {
         // givien
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(memberVIP, 10000);

        // then
        assertEquals(1000, discount);

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void notVipDiscount() {
        Member memberBasic = new Member(2L, "memberBasic", Grade.Basic);

        // when
        int discount = discountPolicy.discount(memberBasic, 10000);

        // then
        assertEquals(0, discount);
    }


}