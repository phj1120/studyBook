package org.parkh.practice.ch09.item57;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

@Slf4j
public class Item57 {

    /**
     * 반복 변수의 범위: for 의 괄호, 반복문의 몸체
     * <p>
     * 외부에서 반복 변수에 접근 할 수 없도록, 반복 변수의 범위 최소화 할 수 있음
     */
    @Test
    void forLoop() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        log.info("for-each");
        for (Integer num : nums) {
            String now = "now";
            log.info("{}", num);
        }

//        log.info("iterator");
//        for (Iterator<Integer> i = nums.iterator(); i.hasNext(); ) {
//            Integer num = i.next();
//            log.info("{}", num);
//        }
        // log.info("{}", num);
        // log.info(now);

        int i = 0;
        for (; i < 5; i++) {
            log.info("{}", i);
        }

    }

    @Test
    void whileLoop() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            String now = "now";
            log.info("{}", iterator.next());
        }
        // log.info(now);

        iterator.hasNext(); // 외부에서 반복 변수에 접근 가능. 실수할 가능성 있음
        while (iterator.hasNext()) {
            log.info("이미 사용된 iterator 로 반복 안 됨.");
        }
    }

}
