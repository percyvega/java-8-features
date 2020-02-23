package com.percyvega.java8.student.suppliers;

import com.percyvega.java8.student.Student;

import java.util.List;

public class StudentsWithNullListSupplier {

    public static List<Student> get() {
        List<Student> students = StudentsListSupplier.get();
        students.add(null);

        return students;
    }

}
