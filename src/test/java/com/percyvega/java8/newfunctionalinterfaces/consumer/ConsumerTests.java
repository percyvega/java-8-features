package com.percyvega.java8.newfunctionalinterfaces.consumer;

import com.percyvega.java8.Student;
import com.percyvega.java8.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static com.percyvega.java8.Constants.FEMALE;

@Log4j2
class ConsumerTests {

    private static final Consumer<Student> logStudentConsumer = log::info;
    private static final Consumer<Student> logStudentNameConsumer = student -> log.info(student::getName);
    private static final Consumer<Student> logStudentActivitiesConsumer = student -> log.info(student::getActivities);

    private static final List<Student> students = StudentService.getAllStudents();

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
    void setLogStudentNamesAndActivities_whenGenderFemale() {
        students.forEach(student -> {
            if (FEMALE.equals(student.getGender())) {
                logStudentNameConsumer.andThen(logStudentActivitiesConsumer).accept(student);
            }
        });
    }

}
