package com.example.springcore.member;

import com.example.springcore.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "지훈", Grade.VIP);

        //when
        memberService.join(member);
        Member member1 = memberService.findMember(member.getId());

        //then
        assertEquals(member, member1);

    }

}