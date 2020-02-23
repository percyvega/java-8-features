package com.percyvega.java8.interfaces;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class DefaultMethodInterfacePersonTest {

    @Test
    void testDefaultMethod1() {
        Person aPerson = new Person();

        assertThat(aPerson.toString()).isEqualTo("Percy is a male");
        assertThat(DefaultMethodInterfacePerson.countNameCharacters(aPerson)).isEqualTo(5);
    }

}
