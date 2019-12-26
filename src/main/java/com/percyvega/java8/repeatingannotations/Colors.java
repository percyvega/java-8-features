package com.percyvega.java8.repeatingannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// to get the annotation information at runtime
@Retention(RetentionPolicy.RUNTIME)
@interface Colors {
    Color[] value();
}
