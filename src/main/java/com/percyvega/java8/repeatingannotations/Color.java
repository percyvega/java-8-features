package com.percyvega.java8.repeatingannotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// to get the annotation information at runtime
@Retention(RetentionPolicy.RUNTIME)
// to enable the repeated use of this annotation
@Repeatable(Colors.class)
@interface Color {
    String name();
}
