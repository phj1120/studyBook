package org.parkh.practice.ch04.item19;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Slf4j
public class Item19 {

    @Test
    void complex() {
        double re = 1;
        double im = 2;
        Complex complex = new Complex(re, im);
        StaticComplex staticComplex = StaticComplex.valueOf(re, im);
    }

    @Test
    void staticClass() {
        Integer integer10 = Integer.valueOf(10);
        integer10 = 20; // 값이 바뀌는 것이 아니라 가리키는 객체가 달라짐
    }

    @Test
    void staticClassKeyMap() {
        Map<String, String> stringMap = new HashMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        stringMap.put(key1, "value");
        stringMap.put(key2, "value");
        stringMap.put(key3, "value");
        System.out.println(stringMap);

        key1 = "newKey";
        System.out.println(stringMap);


        HashSet<String> strSet = new HashSet<>();
        String str1 = "str1";
        String str2 = "str2";
        String str3 = "str3";

        strSet.add(str1);
        strSet.add(str2);
        strSet.add(str3);
        System.out.println(strSet);

        str1 = "newStr";
        System.out.println(strSet);


    }

    static class Key {
        private String key;
    }

    static class Value {
        private String value;
    }

}
