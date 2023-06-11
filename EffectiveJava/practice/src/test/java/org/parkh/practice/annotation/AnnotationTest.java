package org.parkh.practice.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;

@Slf4j
public class AnnotationTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface TestAnno{
        AnnoType[] type();
    }

    enum AnnoType {
        MBR, NON_MBR, ALL
    }

    @TestAnno(type = {AnnoType.MBR, AnnoType.NON_MBR})
    static class TestClass {

    }

    @Test
    void test() {
        TestAnno annotation = TestClass.class.getAnnotation(TestAnno.class);
        AnnoType[] types = annotation.type();
        for (AnnoType annoType : types) {
            System.out.println(annoType);
        }
    }
}
