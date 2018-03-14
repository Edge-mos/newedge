package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */
public class CounterTest {
    @Test
    public void summOfEvenDigitsInRange() {
        Counter counter = new Counter();
        assertThat(counter.add(1, 10), is(30));
    }
}
