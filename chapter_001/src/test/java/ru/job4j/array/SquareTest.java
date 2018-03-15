package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;


/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class SquareTest {
    @Test
    public void whenTestSquareFor10Elems() {
        Square square = new Square();
        int[] expected = new int[] {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        assertArrayEquals(expected, square.calculate(10));

    }
}
