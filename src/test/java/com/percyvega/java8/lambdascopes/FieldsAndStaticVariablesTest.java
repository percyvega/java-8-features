package com.percyvega.java8.lambdascopes;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

@Log4j2
public class FieldsAndStaticVariablesTest {

    static int outerStaticNum;
    int outerNum;

    @Test
    void lambdaScopesTest1() {
        Function<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Function<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }

}
