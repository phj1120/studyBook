package org.parkh.practice.reflection;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

@Slf4j
public class ReflectionTest {

    @Getter
    @ToString
    static class Student {
        private String name;
        private String phoneNumber;

        public Student(String name) {
            this.name = name;
        }
    }

    @Getter
    @ToString
    static class Professor {
        private String name;
        private String phoneNumber;
        private String labNumber;

        public Professor(String name) {
            this.name = name;
        }
    }

    @Test
    void test() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student("student");

        Field phoneNumber = student.getClass().getDeclaredField("phoneNumber");
        phoneNumber.setAccessible(true);
        phoneNumber.set(student, "010-1234");

        System.out.println(student);
    }

    @Test
    void test2() throws NoSuchFieldException, IllegalAccessException {
        Professor professor = new Professor("professor");

        Field phoneNumber = professor.getClass().getDeclaredField("phoneNumber");
        phoneNumber.setAccessible(true);
        phoneNumber.set(professor, "02-1234");

        Field labNumber = professor.getClass().getDeclaredField("labNumber");
        labNumber.setAccessible(true);
        labNumber.set(professor, "02-1234");

        System.out.println(professor);
    }

    @Test
    void test3() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student("student");

        Field phoneNumber = student.getClass().getDeclaredField("phoneNumber");
        phoneNumber.setAccessible(true);
        phoneNumber.set(student, "02-1234");

        Assertions.assertThatThrownBy(() -> {
            Field labNumber = student.getClass().getDeclaredField("labNumber");
            labNumber.setAccessible(true);
            labNumber.set(student, "02-1234");
        }).isInstanceOf(NoSuchFieldException.class);

        System.out.println(student);
    }

    @Test
    void test4() throws NoSuchFieldException, IllegalAccessException {
        Object student = new Student("student");

        Field phoneNumber = student.getClass().getDeclaredField("phoneNumber");
        phoneNumber.setAccessible(true);
        phoneNumber.set(student, "02-1234");

        Assertions.assertThatThrownBy(() -> {
            Field labNumber = student.getClass().getDeclaredField("labNumber");
            labNumber.setAccessible(true);
            labNumber.set(student, "02-1234");
        }).isInstanceOf(NoSuchFieldException.class);

        System.out.println(student);
    }

}
