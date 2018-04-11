package ru.job4j.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    /**
     * Сконвертировать List в двумерный массив.
     * @param list List элементов
     * @param rows число строк, сделать проверку что бы кол-во элементов в массиве было кратно строкам если нет, то заполнить недостающие элементы 0.
     * @return Двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int columns = (list.size() % rows == 0) ? (list.size() / rows) : (list.size() / rows + 1);
        int[][] result = new int[rows][columns];
        int listIndex = 0;
            for (int[] ints : result) {
                for (int i = 0; i < ints.length; i++) {
                    if (listIndex == list.size()) {
                        break;
                    }
                    ints[i] = list.get(listIndex++);
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
