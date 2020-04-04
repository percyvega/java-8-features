package com.percyvega.java8.interfacemultipleinheritance.model;

@FunctionalInterface
public interface Relative {

    String getName();

    default String getRole() {
        return "Father";
    }

}
