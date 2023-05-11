package org.parkh.practice.ch02.item04;

import org.junit.jupiter.api.Test;

public class Item04 {

    @Test
    public void utilityClass() {
        int sum = UtilityClass.sum(1, 2);

//        new UtilityClass(); // 불가능
    }

    /**
     * java 8 부터 interface 에서 static 메서드를 제공할 수 있어져
     * 정적 메서드와 정적 필드만 담고 있는 유틸리티 클래스가 필요할 경우
     * 별도의 Util 클래스를 만들어 제공하지 않고, Interface 에서 제공 할 수 있어짐
     * */
    @Test
    void utilityInterface(){

        UtilityInterface utilityInterface = UtilityInterface.get();
        int sum = utilityInterface.sum(1, 2);
    }
}

