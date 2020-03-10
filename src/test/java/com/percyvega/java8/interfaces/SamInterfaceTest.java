package com.percyvega.java8.interfaces;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class SamInterfaceTest {

    @Test
    void nonFunctional() {
        SamInterface demo = new SamInterface() {
            @Override
            public void print(String s) {
                log.info(s);
            }
        };

        demo.print("Hello!");
    }

    @Test
    void lambda_1() {
        SamInterface demo = (String s) -> log.info(s);

        demo.print("Hello!");
    }

    @Test
    void lambda_2() {
        SamInterface demo = (s) -> log.info(s);

        demo.print("Hello!");
    }

    @Test
    void lambda_3() {
        SamInterface demo = s -> log.info(s);

        demo.print("Hello!");
    }

    @Test
    void methodReference() {
        SamInterface demo = log::info;

        demo.print("Hello!");
    }

}