package org.parkh.practice.ch04.item18;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Slf4j
public class Extend {

    static class InstrumentedHashSet<E> extends HashSet<E> {
        private int addCount = 0;

        public InstrumentedHashSet() {

        }

        public InstrumentedHashSet(int initCap, float loadFactor) {
            super(initCap, loadFactor);
        }

        @Override
        public boolean add(E e) {
            log.info("InstrumentedHashSet.add");
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            log.info("InstrumentedHashSet.addAll");
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }


    @Test
    void InstrumentHashSetTest() {
        System.out.println("Add");
        InstrumentedHashSet<String> addSet = new InstrumentedHashSet<>();
        addSet.add("박");
        addSet.add("현");
        addSet.add("준");
        System.out.println("addSet.getAddCount() = " + addSet.getAddCount());
        System.out.println("addSet.size() = " + addSet.size());

        System.out.println("\nAddAll");
        InstrumentedHashSet<String> addAllSet = new InstrumentedHashSet<>();
        addAllSet.addAll(List.of("박", "현", "준"));
        System.out.println("addAllSet.getAddCount() = " + addAllSet.getAddCount());
        System.out.println("addAllSet.size() = " + addAllSet.size());
    }

}
