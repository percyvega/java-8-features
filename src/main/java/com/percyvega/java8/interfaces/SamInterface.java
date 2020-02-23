package com.percyvega.java8.interfaces;

// The @FunctionalInterface annotation only helps to check (at compile time) if this interface contains a
//      Single Abstract Method or not.
@FunctionalInterface
public interface SamInterface {
    void print(String s);
}