package ru.job4j.streamapi.studentfilter;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private final List<Student> students = List.of(
            new Student("Ben", 45),
            new Student("Dan", 35),
            new Student("Ash", 65),
            new Student("Rick", 69),
            new Student("Zack", 85),
            new Student("Kris", 99)
    );

    private final School school = new School();

    @Test
    public void whenHighScore() {
        List<Student> expected = new ArrayList<>(Arrays.asList(
                new Student("Zack", 85),
                new Student("Kris", 99)));
        List<Student> collect = this.school.collect(students, student -> student.getScore() >= 70 && student.getScore() <= 100);
        assertThat(collect, is(expected));
    }

    @Test
    public void whenMiddleScore() {
        List<Student> expected = new ArrayList<>(Arrays.asList(
                new Student("Ash", 65),
                new Student("Rick", 69)));
        List<Student> collect = this.school.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(collect, is(expected));
    }

    @Test
    public void whenInitialScore() {
        List<Student> expected = new ArrayList<>(Arrays.asList(
                new Student("Ben", 45),
                new Student("Dan", 35)));
        List<Student> collect = this.school.collect(students, student -> student.getScore() > 0 && student.getScore() < 50);
        assertThat(collect, is(expected));
    }

    @Test
    public void whenCollectedStudentFromListToMap() {
        Map<String, Student> result = School.studentsMap(this.students.stream());
        Map<String, Student> expected = new HashMap<>();
        for (Student student : this.students) {
            expected.put(student.getName(), student);
        }
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsAcceptedWithBound() {
        final List<Student> studentsAndNull = Arrays.asList(
                new Student("Ben", 45),
                null,
                new Student("Dan", 35),
                new Student("Ash", 65),
                new Student("Rick", 69),
                null,
                new Student("Zack", 85),
                new Student("Kris", 99),
                null
        );

        List<Student> expected = List.of(
                new Student("Kris", 99),
                new Student("Zack", 85),
                new Student("Rick", 69)
        );
        List<Student> result = this.school.levelOf(studentsAndNull, 69, (integer, student) -> student.getScore() >= integer);
        System.out.println(result);
        System.out.println(expected);
        assertThat(result, is(expected));
    }

}