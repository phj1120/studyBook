package org.parkh.practice.ch02.item06;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

@Slf4j
public class Item06 {

    /**
     * keySet 같은 객체 반환함
     */
    @Test
    void MapInterface() {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> keySet1 = map.keySet();

        map.put("1", 1);
        Set<String> keySet2 = map.keySet();

        map.put("2", 2);
        Set<String> keySet3 = map.keySet();

        map.put("3", 3);
        Set<String> keySet4 = map.keySet();

        log.info("End");
    }

    @Test
    void autoBoxing() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        log.info(String.valueOf(sum));
    }

    @Test
    void autoBoxing2() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        log.info(String.valueOf(sum));
    }
}
