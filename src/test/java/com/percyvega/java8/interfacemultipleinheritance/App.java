package com.percyvega.java8.interfacemultipleinheritance;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
class App {

    @Test
    void testFunctionalInterface() {
        CousinCoworker cousinCoworker = new CousinCoworker();

        log.info(cousinCoworker.getName());
        log.info(cousinCoworker.getRole());
        log.info(cousinCoworker.getSalute("Percy"));
    }

}