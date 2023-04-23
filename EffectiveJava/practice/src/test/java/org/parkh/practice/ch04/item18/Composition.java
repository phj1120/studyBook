package org.parkh.practice.ch04.item18;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 기존 클래스를 상속하는 대신,
 * 새로운 클래스를 만들고 private 필드로 기존 클래스의 인스턴스를 참조하게 하고,
 * 새 클래스의 인스턴스 메서드들은 기존 클래스의 대응하는 메서드를 호출해 그 결과를 반환
 * <p>
 * 기존 클래스가 새로운 클래스의 구성 요소로 쓰인 다는 뜻에서
 * Composition(구성, 조합) 이라 함
 * <p>
 * 새 클래스의 메서드들이 기존 클래스의 메서드를 호출해 결과를 반환하는 형식을
 * Forwarding(전달) 이라 하고,
 * 새 클래스의 메서드를 Forwarding Method(전달 메서드)라 부름.
 */
@Slf4j
public class Composition {
    /**
     * 전달 클래스
     * 기존 클래스의 대응하는 메서드를 호출
     * 어떤 Set 구현체라도 계측 가능
     */
    static class ForwardingSet<E> implements Set<E> {
        private final Set<E> s;

        public ForwardingSet(Set<E> s) {
            this.s = s;
        }

        @Override
        public int size() {
            return s.size();
        }

        @Override
        public boolean isEmpty() {
            return s.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return s.contains(o);
        }

        @Override
        public Iterator<E> iterator() {
            return s.iterator();
        }

        @Override
        public Object[] toArray() {
            return s.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return s.toArray(a);
        }

        @Override
        public boolean add(E e) {
            log.info("ForwardingSet.add");

            return s.add(e);
        }

        @Override
        public boolean remove(Object o) {
            return s.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return s.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            log.info("ForwardingSet.addAll");

            return s.addAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return s.retainAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return s.removeAll(c);
        }

        @Override
        public void clear() {
            s.clear();
        }
    }

    /**
     * Wrapper(래퍼) 클래스, 집합 클래스
     * 다른 Set 에 계측 기능을 덧 씌운다는 뜻에서
     * Decorator pattern 이라 함.
     */
    static class InstrumentedSet<E> extends ForwardingSet<E> {
        private int addCount = 0;

        public InstrumentedSet(Set<E> s) {
            super(s);
        }

        @Override
        public boolean add(E e) {
            log.info("InstrumentedSet.add");

            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            log.info("InstrumentedSet.addAll");

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
        InstrumentedSet<String> addSet = new InstrumentedSet<>(new HashSet<>());
        addSet.add("박");
        addSet.add("현");
        addSet.add("준");
        System.out.println("addSet.getAddCount() = " + addSet.getAddCount());
        System.out.println("addSet.size() = " + addSet.size());

        System.out.println("\nAddAll");
        InstrumentedSet<String> addAllSet = new InstrumentedSet<>(new HashSet<>());
        addAllSet.addAll(List.of("박", "현", "준"));
        System.out.println("addAllSet.getAddCount() = " + addAllSet.getAddCount());
        System.out.println("addAllSet.size() = " + addAllSet.size());
    }

}
