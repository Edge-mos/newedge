package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>(list.size());
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
