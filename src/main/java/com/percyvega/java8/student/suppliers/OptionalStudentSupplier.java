package com.percyvega.java8.student.suppliers;

import com.percyvega.java8.student.Student;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Log4j2
public class OptionalStudentSupplier {

    private static final List<Student> students = StudentsListSupplier.get();
    private static final Random random = new Random();

    public static Optional<Student> get() {
        if (System.nanoTime() % 3 == 0) {
            log.info("Case #1");
            return Optional.of(getRandomStudent());
        } else if (System.nanoTime() % 2 == 0) {
            log.info("Case #2");
            return Optional.ofNullable(getRandomStudentOrSometimesANull());
        } else {
            log.info("Case #3");
            return Optional.empty();
        }
    }

    public static Student getRandomStudent() {
        return students.get(random.nextInt(students.size()));
    }

    private static Student getRandomStudentOrSometimesANull() {
        int studentsCount = students.size();
        int randomInt = random.nextInt(2 * studentsCount);

        if (randomInt < studentsCount) {
            return students.get(randomInt);
        } else {
            return null;
        }
    }

}
