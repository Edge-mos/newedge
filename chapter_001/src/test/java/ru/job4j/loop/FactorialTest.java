package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */
public class FactorialTest {
    @Test
    public void whenValue7ThenFactorial5040() {
        Factorial factorial = new Factorial();
        assertThat(factorial.getFactorial(7), is(5040L));
    }

    @Test
    public void whenValue0ThenFactorial1() {
        Factorial factorial = new Factorial();
        assertThat(factorial.getFactorial(0), is(1L));
    }

    @Test
    public void whenValue11ThenFactorial39916800() {
        Factorial factorial = new Factorial();
        assertThat(factorial.getFactorial(11), is(39916800L));
    }
}
