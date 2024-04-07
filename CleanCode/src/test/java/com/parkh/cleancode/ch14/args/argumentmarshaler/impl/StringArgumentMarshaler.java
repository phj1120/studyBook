package com.parkh.cleancode.ch14.args.argumentmarshaler.impl;

import com.parkh.cleancode.ch14.args.argumentmarshaler.ArgumentMarshaler;
import com.parkh.cleancode.ch14.args.exception.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.parkh.cleancode.ch14.args.exception.ArgsException.ErrorCode.MISSING_STRING;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue = "";

    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArgumentMarshaler)
            return ((StringArgumentMarshaler) am).stringValue;
        else
            return "";
    }
}