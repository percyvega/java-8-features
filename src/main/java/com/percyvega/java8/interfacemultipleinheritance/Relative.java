package com.percyvega.java8.interfacemultipleinheritance;

@FunctionalInterface
public interface Relative {

    String getName();

    default String getRole() {
        return "Father";
    }

    default String getSalute(String addressee) {
        return "Hola " + addressee + "!";
    }

}
