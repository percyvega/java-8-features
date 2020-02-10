package com.percyvega.java8.newfunctionalinterfaces.consumer;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
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
        logStudentConsumer.accept(StudentService.getAllStudents().get(0));
    }

    @Test
    void logStudents() {
        StudentService.getAllStudents().forEach(logStudentConsumer);
    }

    @Test
    void logStudentNames() {
        StudentService.getAllStudents().forEach(logStudentNameConsumer);
    }

    @Test
    void logStudentActivities() {
        StudentService.getAllStudents().forEach(logStudentActivitiesConsumer);
    }

    @Test
    void setLogStudentNamesAndActivities() {
        StudentService.getAllStudents().forEach(logStudentNameConsumer.andThen(logStudentActivitiesConsumer));
    }

    @Test
    void setLogStudentNames_whenGenderMale() {
        StudentService.getAllStudents().forEach(student -> {
            if (MALE.equals(student.getGender())) {
                logStudentNameConsumer.accept(student);
            }
        });
    }

    @Test
    void setLogStudentNamesAndActivities_whenGenderFemale() {
        StudentService.getAllStudents().forEach(student -> {
            if (FEMALE.equals(student.getGender())) {
                logStudentNameConsumer.andThen(logStudentActivitiesConsumer).accept(student);
            }
        });
    }

}
