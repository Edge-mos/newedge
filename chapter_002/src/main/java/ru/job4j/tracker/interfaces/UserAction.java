package ru.job4j.tracker.interfaces;

import ru.job4j.tracker.Tracker;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 26.03.2018.
 */

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
