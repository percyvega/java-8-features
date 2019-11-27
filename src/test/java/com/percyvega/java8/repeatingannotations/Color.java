package com.percyvega.java8.repeatingannotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // to get the annotation information at runtime
@Repeatable(Colors.class) // to enable the repeated use of this annotation
@interface Color {
    String name();
}
