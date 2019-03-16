package ru.job4j.streamapi.studentfilter;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students
                .stream()
                .filter(student -> predicate.test(student))
                .collect(Collectors.toList());
    }

    public static Map<String, Student> studentsMap(Stream<Student> sup) {
        return sup
                .collect(Collectors.toMap(Student::getName, student -> student));

    }

    public List<Student> levelOf(List<Student> students, int bound, BiPredicate<Integer, Student> pred) {
        return students
                .stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .takeWhile(student -> pred.test(bound, student))
                .collect(Collectors.toList());
    }


}
