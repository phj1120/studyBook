package com.parkh.cleancode.ch12.vacation;

import com.parkh.cleancode.ch12.vacation.policy.impl.EUVacationPolicy;
import com.parkh.cleancode.ch12.vacation.policy.impl.USVacationPolicy;
import org.junit.jupiter.api.Test;

public class VacationTest {
    // 템플릿 메서드 패턴은 상속을 기반으로,
    // 정해진 흐름에서 공통과 다른 부분을 다른 부분을 각각의 상속 받은 클래스에서 구현.

    // 전략 패턴은 조합을 기반으로
    // 정해진 흐름에서 사용될 객체를 따로 구현해 두고, 어떤 객체를 사용할지 Context 에 담는다.
    @Test
    void usVacationPolicy() {
        USVacationPolicy usVacationPolicy = new USVacationPolicy();
        usVacationPolicy.accrueVacation();
    }

    @Test
    void euVacationPolicy() {
        EUVacationPolicy euVacationPolicy = new EUVacationPolicy();
        euVacationPolicy.accrueVacation();
    }
}
