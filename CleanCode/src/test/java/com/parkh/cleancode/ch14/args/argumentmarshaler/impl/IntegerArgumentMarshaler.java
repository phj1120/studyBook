package com.parkh.cleancode.ch14.args.argumentmarshaler.impl;

import com.parkh.cleancode.ch14.args.argumentmarshaler.ArgumentMarshaler;
import com.parkh.cleancode.ch14.args.exception.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.parkh.cleancode.ch14.args.exception.ArgsException.ErrorCode.INVALID_INTEGER;
import static com.parkh.cleancode.ch14.args.exception.ArgsException.ErrorCode.MISSING_INTEGER;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int intValue = 0;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    public static int getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).intValue;
        else
            return 0;
    }
}