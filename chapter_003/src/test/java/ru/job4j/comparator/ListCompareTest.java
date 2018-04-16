package ru.job4j.comparator;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.04.2018.
 */

public class ListCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare listCompare = new ListCompare();
        int result = listCompare.compare("Ivanov", "Ivanov");
        assertThat(result, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare listCompare = new ListCompare();
        int result = listCompare.compare("Ivanov", "Ivanova");
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare listCompare = new ListCompare();
        int result = listCompare.compare("Petrov", "Ivanova");
        assertThat(result, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare listCompare = new ListCompare();
        int result = listCompare.compare("Petrov", "Patrov");
        assertThat(result, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare listCompare = new ListCompare();
        int result = listCompare.compare("Patrova", "Petrov");
        assertThat(result, lessThan(0));
    }
}
