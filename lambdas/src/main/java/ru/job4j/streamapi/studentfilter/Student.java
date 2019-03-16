package ru.job4j.streamapi.studentfilter;

import java.util.Comparator;
import java.util.Formatter;
import java.util.Objects;

public class Student {
    private final String name;
    private final int score;

    public Student(final String  name, final int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return String.format("[Name: %s Score: %d]", this.name, this.score);
    }
}
