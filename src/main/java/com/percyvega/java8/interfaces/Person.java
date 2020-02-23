package com.percyvega.java8.interfaces;

public class Person implements DefaultMethodInterfacePerson {

    @Override
    public String getName() {
        return "Percy";
    }

    @Override
    public String toString() {
        return getName() + " is a " + getGender();
    }
}
