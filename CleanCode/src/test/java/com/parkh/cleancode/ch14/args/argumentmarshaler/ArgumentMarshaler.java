package com.parkh.cleancode.ch14.args.argumentmarshaler;


import com.parkh.cleancode.ch14.args.exception.ArgsException;

import java.util.Iterator;

public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}