package com.parkh.cleancode.ch12.vacation.policy.impl;

import com.parkh.cleancode.ch12.vacation.policy.VacationPolicy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class USVacationPolicy extends VacationPolicy {
    @Override
    protected void alterForLegalMinimums() {
        log.info("미국인의 법정 최소 기간으로 변경");
    }
}
