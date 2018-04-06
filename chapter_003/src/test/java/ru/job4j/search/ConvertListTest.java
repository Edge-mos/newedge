package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */
public class ConvertListTest {
    @Test
    public void whenConvertArrayThanGetList() {
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            expected.add(i);
        }
        ConvertList convertList = new ConvertList();
        List<Integer> result = convertList.toList(array);
        assertThat(result, is(expected));
    }

    @Test
    public void whenConvertJaggedArrayThanGetList() {
        int[][] array = new int[][]{
                {1, 14, 8},
                {4},
                {77, 101}
        };
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(14);
        expected.add(8);
        expected.add(4);
        expected.add(77);
        expected.add(101);
        ConvertList convertList = new ConvertList();
        List<Integer> result = convertList.toList(array);
        assertThat(result, is(expected));
    }

    @Test
    public void thenListToArray3X3() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }
        int[][] result = convertList.toArray(list, 3);
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void thenListToArray4X4() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }
        int[][] result = convertList.toArray(list, 4);
        int[][] expected = {
                {1, 2, 3, 4},
                {5, 6, 7, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void thenAddListOfArraysThanGetListOfAllElements() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 23});
        list.add(new int[]{49, 41, 98});
        List<Integer> result = convertList.convert(list);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(23);
        expected.add(49);
        expected.add(41);
        expected.add(98);
        assertThat(result, is(expected));
    }
}
