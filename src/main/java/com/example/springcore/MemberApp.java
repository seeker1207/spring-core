package com.example.springcore;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member 지훈 = new Member(1L, "지훈", Grade.VIP);
        memberService.join(지훈);

        Member findMember = memberService.findMember(1L);
        memberService.findMember(findMember.getId());

        System.out.println("findMember = " + findMember.getName());
        System.out.println("지훈 = " + 지훈.getName());




    }
}
