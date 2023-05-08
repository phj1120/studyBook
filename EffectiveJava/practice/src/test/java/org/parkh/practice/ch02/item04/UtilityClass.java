package org.parkh.practice.ch02.item04;

public class UtilityClass {
    /**
     * 인스턴스화 방지용
     */
    private UtilityClass() {
        throw new AssertionError();
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}