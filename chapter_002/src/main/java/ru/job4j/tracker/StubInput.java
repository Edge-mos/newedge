package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 21.03.2018.
 */

public class StubInput implements Input{
    @Override
    public String ask(String question) {
        return null;
    }
}
