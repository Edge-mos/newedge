package ru.job4j.array;

import java.util.Arrays;

/**
 * Обёртка над строкой.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class ArrayDuplicate {

    public String[] remove(String[] array) {

        int searchRange = array.length;
        int repeatIndex = searchRange - 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < searchRange; j++) {

                if (array[i].equals(array[j])) {
                    swapWords(array, j, repeatIndex);
                    repeatIndex--;
                    searchRange--;
                }
            }
        }
        return Arrays.copyOf(array, searchRange);
    }

    /**
     *
     * @param array Ссылка на исходный массив.
     * @param duplicateIndex Индекс повторяющегося слова в исходном массиве.
     * @param repeatIndex Положение повторяющегося слова в массиве поссле перестановки. После перестановки
     *                       уменьшается на 1.
     */
    private void swapWords(String[] array, int duplicateIndex, int repeatIndex) {

        String temp = array[duplicateIndex];
        array[duplicateIndex] = array[repeatIndex];
        array[repeatIndex] = temp;

    }
}
