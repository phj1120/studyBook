package com.parkh.cleancode.ch09.member;

import com.parkh.cleancode.ch09.exam.ExamService;

class MemberServiceTest {
    private MemberService memberService;
    private ExamService examService;

    void publicMethod() {
        examService.publicMethod();
        memberService.publicMethod();
    }

    void  protectedMethod(){
//        examService.protectedMethod();
        memberService.protectedMethod();
    }

    void defaultMethod() {
//        examService.defaultMethod();
        memberService.defaultMethod();
    }

    void privateMethod() {
//        examService.privateMethod();
//        memberService.privateMethod();
    }
}