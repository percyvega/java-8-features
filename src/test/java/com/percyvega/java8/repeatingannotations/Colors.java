package com.percyvega.java8.repeatingannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // to get the annotation information at runtime
@interface Colors {
    Color[] value();
}
