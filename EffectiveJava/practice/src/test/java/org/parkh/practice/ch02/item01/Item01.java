package org.parkh.practice.ch02.item01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class Item01 {

    @Test
    @DisplayName("서비스 제공자 프레임워크")
    void serviceProviderFramework() {
        ServiceManager.register(new Vendor1());
        ServiceManager.register(new Vendor2());

        log.info("ServiceManager: {}", ServiceManager.get().getClass());
        log.info("ServiceManager: {}", ServiceManager.get().getClass());
        log.info("ServiceManager: {}", ServiceManager.get().getClass());
        log.info("ServiceManager: {}", ServiceManager.get().getClass());
        log.info("ServiceManager: {}", ServiceManager.get().getClass());
    }


}
