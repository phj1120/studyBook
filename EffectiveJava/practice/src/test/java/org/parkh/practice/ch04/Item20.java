package org.parkh.practice.ch04;

import org.junit.jupiter.api.Test;

public class Item20 {

    /**
     * 인터페이스 default, static 메서드
     */
    interface Singer {
        AudioClip sing(Song song);


//        private default void defaultMethod1() { // default 메서드 public 만 가능

        default void defaultMethod2() {
            sing(null);
        }

        private static void staticMethod1() {
            // sing(null); // 정적 메서드이기 때문에 호출 불가능
        }

        public static void staticMethod2() {
            // sing(null);
        }
    }

    interface SongWriter {
        Song compose(int chartPosition);
    }

    interface SingerSongWriter extends Singer, SongWriter {
        default AudioClip sing(Song song) {
            return new AudioClip();
        }
    }

    static class Song {
    }

    static class AudioClip {
    }

    @Test
    void interfaceTest() {
        Singer singer = new Singer() {
            @Override
            public AudioClip sing(Song song) {
                return null;
            }
        };

        singer.defaultMethod2();

        Singer.staticMethod2();

        SingerSongWriter singerSongWriter = new SingerSongWriter() {
            @Override
            public Song compose(int chartPosition) {
                return null;
            }
        };

        singerSongWriter.defaultMethod2();

        // SingerSongWriter.staticMethod2(); // 없음
    }

    /**
     * 템플릿 메서드
     */
    interface Interface {
        public static Integer val = 10;
        // private static Integer val2 = 20; // public 만 가능


        default void defaultMethod() {
        }

        // default public String toString() {// Objects 의 method override 불가

        void abstractMethod();

        void method();
    }

    static abstract class AbstractInterface implements Interface {
        abstract public void abstractMethod();

        @Override
        public String toString() { // Objects 의 method override 가능
            return "";
        }

        public void method() {

        }
    }

    @Test
    void template() {
        AbstractInterface abstractInterface = new AbstractInterface() {
            @Override
            public void abstractMethod() {

            }
        };
    }


}
