package ru.job4j.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */
public class ConvertList {

    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();

        for (int[] rowsArray : array) {
            for (int element : rowsArray) {
                result.add(element);
            }
        }
        return result;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int[][] result = new int[rows][rows];
        int listIndex = 0;
        int difference = rows * rows - list.size();

        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                list.add(0);
            }

            while (listIndex < list.size()) {
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result.length; j++) {
                        result[i][j] = list.get(listIndex++);
                    }
                }
            }
        }
        return result;
    }
}
