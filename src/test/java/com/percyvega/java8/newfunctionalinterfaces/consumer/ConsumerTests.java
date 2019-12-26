package com.percyvega.java8.newfunctionalinterfaces.consumer;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static com.percyvega.java8.student.Constants.FEMALE;
import static com.percyvega.java8.student.Constants.MALE;

@Log4j2
class ConsumerTests {

    private static final Consumer<Student> logStudentConsumer = log::info;
    private static final Consumer<Student> logStudentNameConsumer = student -> log.info(student::getName);
    private static final Consumer<Student> logStudentActivitiesConsumer = student -> log.info(student::getActivities);

    private static final List<Student> students = StudentService.getAllStudents();

    @Test
    void logStudent() {
        logStudentConsumer.accept(students.get(0));
    }

    @Test
    void logStudents() {
        students.forEach(logStudentConsumer);
    }

    @Test
    void logStudentNames() {
        students.forEach(logStudentNameConsumer);
    }

    @Test
    void logStudentActivities() {
        students.forEach(logStudentActivitiesConsumer);
    }

    @Test
    void setLogStudentNamesAndActivities() {
        students.forEach(logStudentNameConsumer.andThen(logStudentActivitiesConsumer));
    }

    @Test
    void setLogStudentNames_whenGenderMale() {
        students.forEach(student -> {
            if (MALE.equals(student.getGender())) {
                logStudentNameConsumer.accept(student);
            }
        });
    }

    @Test
    void setLogStudentNamesAndActivities_whenGenderFemale() {
        students.forEach(student -> {
            if (FEMALE.equals(student.getGender())) {
                logStudentNameConsumer.andThen(logStudentActivitiesConsumer).accept(student);
            }
        });
    }

}
