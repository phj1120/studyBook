package com.parkh.cleancode.ch14;

import com.parkh.cleancode.ch14.args.Args;
import com.parkh.cleancode.ch14.args.exception.ArgsException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ListIterator;

class ArgsTests {

    @Test
    void util() {
        String str = "-l 1234";
        char c = str.charAt(0);
        String substring = str.substring(1);

        System.out.println("FINISH");
    }

    @Test
    void iter() {
        ListIterator<String> currentArgument;
        List<String> args = List.of("-l", "1234", "-d", "5678");

        for (currentArgument = args.listIterator(); currentArgument.hasNext(); ) {
            String argString = currentArgument.next();
            if (argString.startsWith("-")) {
                String substring = argString.substring(1);
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    @Test
    public void args() {
        String[] args = {"-l", "-p", "8080", "-d", "/home"};

        try {
            Args arg = new Args("l,f,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            boolean falseValue = arg.getBoolean('f');
            int port = arg.getInt('p');
            String directory = arg.getString('d');

            Assertions.assertThat(logging).isTrue();
            Assertions.assertThat(falseValue).isFalse();
            Assertions.assertThat(port).isEqualTo(8080);
            Assertions.assertThat(directory).isEqualTo("/home");
        } catch (ArgsException e) {
            throw new RuntimeException(e);
        }
    }
}
