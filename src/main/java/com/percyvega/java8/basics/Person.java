package com.percyvega.java8.basics;

public class Person implements DefaultMethodInterface {

    @Override
    public String toString() {
        return getName() + " is a " + getGender();
    }
}
