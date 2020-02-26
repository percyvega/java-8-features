package com.percyvega.java8.newfunctionalinterfaces.function;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

@Log4j2
public class FunctionTest {

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

    public static final Function<List<Student>, Double> calculateAverageGpa = students1 -> {
        return students1.stream().mapToDouble(Student::getGpa).average().getAsDouble();
    };

    @Test
    void toUpperCase() {
        StudentsListSupplier.get().forEach(student -> {
            String s = upperCaseFunction1.apply(student.getName()) + ", " +
                    upperCaseFunction2.apply(student.getName()) + ", " +
                    upperCaseFunction3.apply(student.getName());

            log.info(s);
        });
    }

    @Test
    void toUpperCase_then_replaceSpacesWithUnderscore() {
        StudentsListSupplier.get().forEach(student -> log.info(upperCaseFunction3.andThen(replaceSpacesWithUnderscores).apply(student.getName())));
    }

    @Test
    void surroundWithTwoSpaces_then_replaceSpacesWithUnderscore() {
        StudentsListSupplier.get().forEach(student -> log.info(surroundWithTwoSpaces.andThen(replaceSpacesWithUnderscores).apply(student.getName())));
    }

    @Test
    void replaceSpacesWithUnderscore_then_surroundWithTwoSpaces() {
        StudentsListSupplier.get().forEach(student -> log.info(surroundWithTwoSpaces.compose(replaceSpacesWithUnderscores).apply(student.getName())));
    }

    @Test
    void calculateAverageGpa() {
        log.info(calculateAverageGpa.apply(StudentsListSupplier.get()));
    }
}
