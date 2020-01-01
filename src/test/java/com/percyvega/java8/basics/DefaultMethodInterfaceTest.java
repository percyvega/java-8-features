package com.percyvega.java8.basics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class DefaultMethodInterfaceTest {

    @Test
    void testDefaultMethod1() {
        DefaultMethodInterface aPerson = new Person();

        log.info(aPerson);
    }

}
