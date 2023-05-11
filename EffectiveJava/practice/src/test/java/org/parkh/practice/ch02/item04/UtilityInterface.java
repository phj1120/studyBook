package org.parkh.practice.ch02.item04;

public interface UtilityInterface {

    int sum(int a, int b);

    // java 8 부터 지원(Extension methods)
    static UtilityInterface get() {
        return new UtilityInterface() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
    }
}
