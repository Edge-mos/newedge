package ru.job4j.search;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

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

    /**
     * Сконвертировать List в двумерный массив.
     * @param list List элементов
     * @param rows число строк, сделать проверку что бы кол-во элементов в массиве было кратно строкам если нет, то заполнить недостающие элементы 0.
     * @return Двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int columns = (list.size() % rows == 0) ? (list.size() / rows) : (list.size() / rows + 1);
        int[][] result = new int[rows][columns];
        int i = 0;
        int j = 0;
        for (Integer element : list) {
            if (j < columns) {
                result[i][j++] = element;
            } else {
                j = 0;
                result[++i][j++] = element;
            }
        }
        return result;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] ints : list) {
            for (int element : ints) {
                result.add(element);
            }
        }
        return result;
    }
}
