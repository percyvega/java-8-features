package com.percyvega.java8.multipleinheritance;

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

class CousinCoworker implements Relative, Employee {

    @Override
    public String getName() {
        return "Percy Vega";
    }

    @Override
    public String getRole() {
        return Relative.super.getRole() + "/" + Employee.super.getRole();
    }

    @Override
    public String getSalute(String addressee) {
        return Employee.super.getSalute(addressee);
    }

}