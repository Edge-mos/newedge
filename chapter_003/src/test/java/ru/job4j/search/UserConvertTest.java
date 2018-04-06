package ru.job4j.search;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void thenConvertListOfUsersThanGetMapOfUsers() {
        UserConvert userConvert = new UserConvert();
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Vladimir", "Moscow"));
        users.add(new User(2, "Ivan", "SPB"));
        HashMap<Integer, User> res = userConvert.process(users);
        User search = res.get(1);

        assertThat(search, is(users.get(0)));
    }
}
