package ru.job4j.search.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }

     public List<User> sortNameLenght(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
     }

     public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
               return o1.getName().compareTo(o2.getName()) + Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
     }

}
