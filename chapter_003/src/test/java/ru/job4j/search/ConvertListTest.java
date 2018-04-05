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
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        StringBuilder expected = new StringBuilder();
        for (int[] ints : array) {
            for (int anInt : ints) {
                expected.append(String.format("%s ", anInt));
            }
        }

        ConvertList convertList = new ConvertList();
        List<Integer> res = convertList.toList(array);
        StringBuilder result = new StringBuilder();
        for (Integer integer : res) {
            result.append(String.format("%s ", integer));
        }

        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void listToArray() {

        ConvertList convertList = new ConvertList();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }

        int[][] res = convertList.toArray(list, 3);
        StringBuilder result = new StringBuilder();
        for (int[] rows : res) {
            for (int element : rows) {
                result.append(String.format("%s ", element));
            }
        }

        assertThat(result.toString(), is("1 2 3 4 5 6 7 0 0 "));
    }

}
