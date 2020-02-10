package com.percyvega.java8.newfunctionalinterfaces.function;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.percyvega.java8.student.Constants.FEMALE;
import static com.percyvega.java8.student.Constants.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BinaryOperatorTests {

    public static final BinaryOperator<List<Student>> addTwoStudentLists = (students1, students2) -> {
        students1.addAll(students2);
        return students1;
    };

    @Test
    void test_addTwoStudentLists() {
        List<Student> maleStudents = StudentService.getAllStudents().stream()
                .filter(student -> MALE.equals(student.getGender()))
                .collect(Collectors.toList());
        List<Student> femaleStudents = StudentService.getAllStudents().stream()
                .filter(student -> FEMALE.equals(student.getGender()))
                .collect(Collectors.toList());

        List<Student> maleFemaleStudents = addTwoStudentLists.apply(maleStudents, femaleStudents);

        assertThat(StudentService.getAllStudents().size()).isEqualTo(maleFemaleStudents.size());
    }

}
