package com.percyvega.java8.lambdascopes;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

@Log4j2
public class LocalVariableTest {

    @Test
    void lambdaScopesTest1() {
        final int num = 1;

        Function<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

        log.info(stringConverter.apply(2));
    }

    @Test
    void lambdaScopesTest2() {
        int num = 1;

        Function<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

        log.info(stringConverter.apply(2));
    }

    @Test
    void lambdaScopesTest3() {
        int num = 1;

//        variable used in lambda expression should be final or effectively final
//        Function<Integer, String> stringConverter = (from) -> String.valueOf(from + num++);
        Function<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

        log.info(stringConverter.apply(2));
    }

}
