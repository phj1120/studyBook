package com.parkh.cleancode.ch14.args.argumentmarshaler.impl;


import com.parkh.cleancode.ch14.args.argumentmarshaler.ArgumentMarshaler;
import com.parkh.cleancode.ch14.args.exception.ArgsException;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
        /**
         * 들어온 값에 상관 없이 true 를 세팅 하는 게 잘 못 되었다 생각해 아래와 같이 수정했다.
         * String parameter = currentArgument.next();
         * booleanValue = Boolean.parseBoolean(parameter);
         *
         * 하지만 작성자가 잘 못 된 것이 아니라, 생략을 의도하고 이렇게 개발 한 거였다.
         * 예를 들어, -w 는 warn level 의 로그, -d 는 debug level 의 로그를 표시 하는 값이라 하고, 상세 로그를 보여주고 싶을 때,
         * 작성자 버전: -v
         * 내 버전: -v true -d false
         * 작성자 버전이 훨씬 간단하게 처리 가능하다.
         * 추가로 true, false 과 같은 값을 직접 다 입력 받는 것은 좋지 못 한 생각 임.
         *
         * 참고
         * http://butunclebob.com/ArticleS.UncleBob.CleanCodeArgs
         * 댓글: Tue, 21 Feb 2006 12:40:55, Uncle Bob, Ravi's version
         */
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}