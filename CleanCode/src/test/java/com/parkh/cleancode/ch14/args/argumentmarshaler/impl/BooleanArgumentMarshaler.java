package com.parkh.cleancode.ch14.args.argumentmarshaler.impl;


import com.parkh.cleancode.ch14.args.argumentmarshaler.ArgumentMarshaler;
import com.parkh.cleancode.ch14.args.exception.ArgsException;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        // 책에서는 그냥 true 대입 했는데, 그러면 boolean Argument 제대로 변환 못 함.
        String parameter = currentArgument.next();
        booleanValue = Boolean.parseBoolean(parameter);
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}