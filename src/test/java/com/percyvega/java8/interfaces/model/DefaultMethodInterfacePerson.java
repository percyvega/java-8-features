package com.percyvega.java8.interfaces.model;

import static com.percyvega.java8.student.Constants.MALE;

public interface DefaultMethodInterfacePerson {

    default String getName() {
        return "Joe";
    }

    default String getGender() {
        return MALE;
    }

    static int countNameCharacters(Person person) {
        return person.getName().length();
    }

}
