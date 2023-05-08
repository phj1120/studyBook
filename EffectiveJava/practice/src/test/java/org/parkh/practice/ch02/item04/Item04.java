package org.parkh.practice.ch02.item04;

import org.junit.jupiter.api.Test;

public class Item04 {

    @Test
    public void utilityClass() {
        int sum = UtilityClass.sum(1, 2);

//        new UtilityClass(); // 불가능
    }

    void utilityInterface(){
        // java 8 부터 interface 에서 static 메서드를 제공할 수 있어졌음
        UtilityInterface utilityInterface = UtilityInterface.get();
    }
}

