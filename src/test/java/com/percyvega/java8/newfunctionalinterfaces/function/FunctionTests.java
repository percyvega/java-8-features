package com.percyvega.java8.newfunctionalinterfaces.function;

import com.percyvega.java8.Student;
import com.percyvega.java8.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

@Log4j2
public class FunctionTests {

    public static final Function<String, String> upperCaseFunction1 = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s.toUpperCase();
        }
    };
    public static final Function<String, String> upperCaseFunction2 = s -> s.toUpperCase();
    public static final Function<String, String> upperCaseFunction3 = String::toUpperCase;

    public static final Function<String, String> replaceSpacesWithUnderscores = s -> s.replace(" ", "_");
    public static final Function<String, String> surroundWithTwoSpaces = s -> "  " + s + "  ";

    private static final List<Student> students = StudentService.getAllStudents();

    @Test
    void toUpperCase() {
        students.forEach(student -> {
            String s = upperCaseFunction1.apply(student.getName()) + ", " +
                    upperCaseFunction2.apply(student.getName()) + ", " +
                    upperCaseFunction3.apply(student.getName());

            log.info(s);
        });
    }

    @Test
    void toUpperCase_then_replaceSpacesWithUnderscore() {
        students.forEach(student -> log.info(upperCaseFunction3.andThen(replaceSpacesWithUnderscores).apply(student.getName())));
    }

    @Test
    void surroundWithTwoSpaces_then_replaceSpacesWithUnderscore() {
        students.forEach(student -> log.info(surroundWithTwoSpaces.andThen(replaceSpacesWithUnderscores).apply(student.getName())));
    }

    @Test
    void replaceSpacesWithUnderscore_then_surroundWithTwoSpaces() {
        students.forEach(student -> log.info(surroundWithTwoSpaces.compose(replaceSpacesWithUnderscores).apply(student.getName())));
    }

}
