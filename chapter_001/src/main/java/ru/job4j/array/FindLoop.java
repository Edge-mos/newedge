package ru.job4j.array;


/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                result = i;
                break;
            }
        }
        return result;
    }
}
