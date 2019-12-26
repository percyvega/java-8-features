package com.percyvega.java8.interfacemultipleinheritance;

@FunctionalInterface
public interface Employee {

    String getName();

    default String getRole() {
        return "Manager";
    }

    default String getSalute(String addressee) {
        return "Good morning, " + addressee;
    }

}
