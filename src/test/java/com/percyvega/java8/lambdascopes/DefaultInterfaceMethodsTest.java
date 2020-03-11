package com.percyvega.java8.lambdascopes;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class DefaultInterfaceMethodsTest {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }

        static int square(int a) {
            return a * a;
        }
    }

    @Test
    void test1() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        log.info(formula.calculate(100));
        log.info(formula.sqrt(16));
    }

    @Test
    void test2() {
        Formula formula = (a -> a + a);

        log.info(formula.calculate(100));
        log.info(formula.sqrt(16));
    }

    @Test
    void test3() {
        Formula formula = (a -> Formula.square(a));

        log.info(formula.calculate(100));
        log.info(formula.sqrt(16));
    }

    @Test
    void test4() {
        // Non static method cannot be referenced from a static context
//        Formula formula = (a -> Formula.sqrt(a));
        Formula formula = (a -> a + a);

        log.info(formula.calculate(100));
        log.info(formula.sqrt(16));
    }

}
