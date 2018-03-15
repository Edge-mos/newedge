package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] initialArray = new int[] {2, 6, 1, 4};
        int[] expected = new int[]{4, 1, 6, 2};
        int[] result = turn.back(initialArray);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] initialArray = new int[] {1, 2, 3, 4, 5};
        int[] expected = new int[]{5, 4, 3, 2, 1};
        int[] result = turn.back(initialArray);
    }
}
