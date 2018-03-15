package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class FindLoopTest {
    @Test
    public void whenArrayContainsElement() {
        FindLoop findLoop = new FindLoop();
        int[] data = new int[]{56, 49, 3324, 48};
        int result = findLoop.indexOf(data, 3324);
        int expected = 2;
        assertThat(expected, is(result));
    }

    @Test
    public void whenArrayNotContainsElement() {
        FindLoop findLoop = new FindLoop();
        int[] data = new int[]{56, 49, 3324, 48};
        int result = findLoop.indexOf(data, 33);
        int expected = -1;
        assertThat(expected, is(result));
    }
}
