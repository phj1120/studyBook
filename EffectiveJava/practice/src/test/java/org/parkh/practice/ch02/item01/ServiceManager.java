package org.parkh.practice.ch02.item01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceManager {
    public static List<ServiceInterface> vendors = new ArrayList<>();

    // 제공자 등록 API: 제공자가 구현체를 등록할 때 사용
    static void register(ServiceInterface serviceInterface) {
        vendors.add(serviceInterface);
    }

    // 서비스 접근 API: 클라이언트가 서비스의 인스턴스를 얻을 때 사용
    public static ServiceInterface get() {
        return vendors.get(new Random().nextInt(0, vendors.size()));
    }
}
