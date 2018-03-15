package ru.job4j.array;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class Turn {
    public int[] back(int[] array) {

        int j = array.length - 1;

        for (int i = 0; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
