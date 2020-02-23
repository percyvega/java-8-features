package com.percyvega.java8.student.suppliers;

import com.percyvega.java8.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.percyvega.java8.student.Constants.FEMALE;
import static com.percyvega.java8.student.Constants.MALE;

public class StudentsListSupplier {

    public static List<Student> get() {
        List<Student> students = new ArrayList<>();

        Student matt = new Student("Matt Damon", 2, 3.6, MALE, 10, Arrays.asList("dancing", "basketball", "volleyball"), Optional.empty());
        students.add(matt);
        Student julia = new Student("Julia Roberts", 2, 3.5, FEMALE, 11, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(matt));
        students.add(julia);
        Student george = new Student("George Clooney", 2, 3.8, MALE, 11, Arrays.asList("aerobics", "gymnastics", "soccer"), Optional.empty());
        students.add(george);
        Student meryl = new Student("Meryl Streep", 2, 3.3, FEMALE, 10, Arrays.asList("dancing", "basketball", "volleyball"), Optional.of(george));
        students.add(meryl);
        Student johnny = new Student("Johnny Depp", 2, 3.9, MALE, 11, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(meryl));
        students.add(johnny);
        Student ben = new Student("Ben Affleck", 3, 3.0, MALE, 12, Arrays.asList("dancing", "gymnastics", "aerobics"), Optional.of(meryl));
        students.add(ben);
        Student elizabeth = new Student("Elizabeth Taylor", 3, 3.5, FEMALE, 15, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(george));
        students.add(elizabeth);
        Student clint = new Student("Clint Eastwood", 3, 3.7, MALE, 12, Arrays.asList("dancing", "gymnastics", "aerobics"), Optional.of(julia));
        students.add(clint);
        Student cate = new Student("Cate Blanchett", 3, 3.9, FEMALE, 15, Arrays.asList("aerobics", "gymnastics", "football"), Optional.of(clint));
        students.add(cate);
        Student kevin = new Student("Kevin Spacey", 3, 3.3, MALE, 15, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.empty());
        students.add(kevin);
        Student emma = new Student("Emma Thompson", 3, 4.0, FEMALE, 15, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(clint));
        students.add(emma);
        Student robert = new Student("Robert De Niro", 4, 3.5, MALE, 10, Arrays.asList("aerobics", "dancing", "football"), Optional.of(emma));
        students.add(robert);
        Student jodie = new Student("Jodie Foster", 4, 3.9, FEMALE, 10, Arrays.asList("swimming", "dancing", "soccer"), Optional.of(robert));
        students.add(jodie);
        Student brad = new Student("Brad Pitt", 4, 3.5, MALE, 10, Arrays.asList("swimming", "dancing", "football"), Optional.of(jodie));
        students.add(brad);
        Student sigourney = new Student("Sigourney Weaver", 4, 3.4, FEMALE, 22, Arrays.asList("aerobics", "basketball", "baseball", "football"), Optional.of(robert));
        students.add(sigourney);

        return students;
    }

}
