package com.percyvega.java8.interfaces;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Log4j2
public class CollectionsSort {

    List<String> names = Arrays.asList("She", "It", "I", "He", "Abstract", "Internationalization", "Four", "Seven");

    @Test
    void test1() {
        Collections.sort(names);
        log.info(names);

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() < o2.length() ? -1 : 1;
            }
        });
        log.info(names);

        Collections.sort(names, (String o1, String o2) -> {
            return o1.length() > o2.length() ? -1 : 1;
        });
        log.info(names);

        Collections.sort(names, (String o1, String o2) -> o1.length() < o2.length() ? -1 : 1);
        log.info(names);

        Collections.sort(names, (o1, o2) -> o1.length() > o2.length() ? -1 : 1);
        log.info(names);

        Collections.sort(names, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        log.info(names);

        Collections.sort(names, Comparator.comparingInt(String::length));
        log.info(names);

        names.sort(Comparator.comparingInt(String::length));
        log.info(names);
    }

}
