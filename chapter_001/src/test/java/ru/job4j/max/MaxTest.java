package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */

public class MaxTest {
    @Test
    public void whenFirstGreatherSecond() {
        Max maximum = new Max();
        assertThat(maximum.maxOfTwoIntegers(2, 1), is(2));
    }

    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        assertThat(maximum.maxOfTwoIntegers(1, 2), is(2));
    }
}
