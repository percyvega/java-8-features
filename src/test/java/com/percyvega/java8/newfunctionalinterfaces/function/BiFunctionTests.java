package com.percyvega.java8.newfunctionalinterfaces.function;

import com.percyvega.java8.student.Student;
import com.percyvega.java8.student.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.percyvega.java8.newfunctionalinterfaces.predicate.PredicateTests.gpaGt35MaleStudentPredicate;

@Log4j2
public class BiFunctionTests {

    private static final List<Student> students = StudentService.getAllStudents();

    public static final BiFunction<List<Student>, Predicate<Student>, List<Student>> getNamesOfStudents = (students, studentPredicate) -> {
        return students.stream().filter(studentPredicate).collect(Collectors.toList());
    };

    @Test
    void getNamesOfStudentsTest() {
        getNamesOfStudents.apply(students, gpaGt35MaleStudentPredicate).forEach(log::info);
    }

}
