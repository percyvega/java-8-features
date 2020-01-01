package com.percyvega.java8.basics;

import static com.percyvega.java8.student.Constants.MALE;

public interface DefaultMethodInterface {

    default String getName() {
        return "Joe";
    }

    default String getGender() {
        return MALE;
    }

}
