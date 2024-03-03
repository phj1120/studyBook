package com.parkh.cleancode.ch12.vacation.policy;

import lombok.extern.slf4j.Slf4j;

/**
 * 템플릿 메서드 패턴
 * - 고차원 중복을 제거하는 방법
 */
@Slf4j
public abstract class VacationPolicy {
    public void accrueVacation() {
        calculateBaseVacationHours();
        alterForLegalMinimums();
        applyToPayroll();
    }

    private void calculateBaseVacationHours() {
        log.info("공통: 기본 휴가 시간 계산");
    }

    // 중복되지 않은 부분만 각 클래스에서 구현.
    abstract protected void alterForLegalMinimums();

    private void applyToPayroll() {
        log.info("공통: 급여 지급");
    }
}

