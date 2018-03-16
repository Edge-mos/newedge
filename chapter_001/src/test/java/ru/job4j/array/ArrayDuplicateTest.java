package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */


public class ArrayDuplicateTest {
    @Test
    public void whenDuplicatesOccursInArray() {

        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] initial = new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = arrayDuplicate.remove(initial);
        String[] expected = new String[]{"Привет", "Мир", "Супер"};

        assertThat(result, is(expected));
    }

    @Test
    public void whenNoDuplicatesInArray() {

        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] initial = new String[]{"1", "2", "3", "4", "5"};
        String[] result = arrayDuplicate.remove(initial);
        String[] expected = new String[]{"1", "2", "3", "4", "5"};

        assertThat(result, is(expected));
    }


}
