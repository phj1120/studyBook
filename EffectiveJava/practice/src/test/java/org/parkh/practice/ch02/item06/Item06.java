package org.parkh.practice.ch02.item06;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

public class Item06 {

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
    }

}
