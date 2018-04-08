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
                        new User("Ivan", 21),
                        new User("Vladimir", 33),
                        new User("Petr", 15)
                )
        );
        SortUser sortUser = new SortUser();
        result = sortUser.sort(list);
        Iterator<User> it = result.iterator();
        assertThat(it.next(), is(list.get(2)));
    }
}
