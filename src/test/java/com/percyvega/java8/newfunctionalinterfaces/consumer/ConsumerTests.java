package com.percyvega.java8.newfunctionalinterfaces.consumer;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static com.percyvega.java8.student.Constants.FEMALE;
import static com.percyvega.java8.student.Constants.MALE;

@Log4j2
class ConsumerTests {

    private static final Consumer<Student> logStudentConsumer = log::info;
    private static final Consumer<Student> logStudentNameConsumer = student -> log.info(student::getName);
    private static final Consumer<Student> logStudentActivitiesConsumer = student -> log.info(student::getActivities);

    @Test
    void logStudent() {
        logStudentConsumer.accept(StudentsListSupplier.get().get(0));
    }

    @Test
    void logStudents() {
        StudentsListSupplier.get().forEach(logStudentConsumer);
    }

    @Test
    void logStudentNames() {
        StudentsListSupplier.get().forEach(logStudentNameConsumer);
    }

    @Test
    void logStudentActivities() {
        StudentsListSupplier.get().forEach(logStudentActivitiesConsumer);
    }

    @Test
    void setLogStudentNamesAndActivities() {
        StudentsListSupplier.get().forEach(logStudentNameConsumer.andThen(logStudentActivitiesConsumer));
    }

    @Test
    void setLogStudentNames_whenGenderMale() {
        StudentsListSupplier.get().forEach(student -> {
            if (MALE.equals(student.getGender())) {
                logStudentNameConsumer.accept(student);
            }
        });
    }

    @Test
    void setLogStudentNamesAndActivities_whenGenderFemale() {
        StudentsListSupplier.get().forEach(student -> {
            if (FEMALE.equals(student.getGender())) {
                logStudentNameConsumer.andThen(logStudentActivitiesConsumer).accept(student);
            }
        });
    }

}
