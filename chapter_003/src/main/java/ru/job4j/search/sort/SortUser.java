package ru.job4j.search.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }

}
