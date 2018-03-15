package ru.job4j.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {

        BubbleSort bubbleSort = new BubbleSort();
        int[] initial = new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 9, 5};
        int[] expected = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8, 9};
        int[] result = bubbleSort.sort(initial);
        assertThat(result, is(expected));

    }
}
