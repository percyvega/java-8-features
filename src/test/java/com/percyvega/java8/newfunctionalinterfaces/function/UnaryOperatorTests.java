package com.percyvega.java8.newfunctionalinterfaces.function;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Log4j2
public class UnaryOperatorTests {

    public static final UnaryOperator<List<Student>> studentsWithGpaGreaterThan35 = studentList -> studentList.stream()
            .filter(student -> student.getGpa() > 3.5)
            .collect(Collectors.toList());

    private static final List<Student> students = StudentService.getAllStudents();

    @Test
    void test_studentsWithGpaGreaterThan35() {
        studentsWithGpaGreaterThan35.apply(students).forEach(log::info);
    }

}
