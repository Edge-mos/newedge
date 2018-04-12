package ru.job4j.search;
import org.junit.Test;

import java.util.*;

import ru.job4j.search.sort.SortUser;
import ru.job4j.search.sort.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 07.04.2018.
 */
public class SortUserTest {
    @Test
    public void whetGetTreeSet() {
        List<User> list = new ArrayList<>();
        Set<User> result = new TreeSet<>();
        list.addAll(
                Arrays.asList(
                        new User("Ivan", 1),
                        new User("Vladimir", 2),
                        new User("Petr", 4),
                        new User("Andrey", 3)
                )
        );
        SortUser sortUser = new SortUser();
        result = sortUser.sort(list);
       Set<User> expected = new TreeSet<>();
       expected.addAll(
               Arrays.asList(
                       new User("Ivan", 1),
                       new User("Vladimir", 2),
                       new User("Andrey", 3),
                       new User("Petr", 4)
               )
       );
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortByNameLenghtComparator() {
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("Donald", 71),
                        new User("Vladimir", 65),
                        new User("Xi", 64)
                )
        );
        SortUser sortUser = new SortUser();
        assertThat(sortUser.sortNameLenght(list).get(0).getName(), is("Xi"));
    }

    @Test
    public void whenSortByAllFieldsComparator() {
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("Сергей", 25),
                        new User("Иван", 30),
                        new User("Сергей", 20),
                        new User("Иван", 25),
                        new User("Ан", 23),
                        new User("Ан", 20)
                )
        );
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(list);
        List<User> expected  = new ArrayList<>();
        expected.addAll(
                Arrays.asList(
                        new User("Ан", 20),
                        new User("Ан", 23),
                        new User("Иван", 25),
                        new User("Иван", 30),
                        new User("Сергей", 20),
                        new User("Сергей", 25)
                )
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortSameNameByAllFields() {
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("Сергей", 3),
                        new User("Сергей", 1),
                        new User("Сергей", 2)
                )
        );
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(list);
        List<User> expected  = new ArrayList<>();
        expected.addAll(
                Arrays.asList(
                        new User("Сергей", 1),
                        new User("Сергей", 2),
                        new User("Сергей", 3)
                )
        );
        assertThat(result, is(expected));

    }
}
