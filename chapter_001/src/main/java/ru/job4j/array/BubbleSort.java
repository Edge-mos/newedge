package ru.job4j.array;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */


public class BubbleSort {
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    change(array, j);
                }
            }
        }
        return array;
    }

    private void change(int[] array, int j) {

            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
    }
}
