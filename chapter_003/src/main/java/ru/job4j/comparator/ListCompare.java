package ru.job4j.comparator;

import java.util.Comparator;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * Написать компаратор для строк.
 * @version $2$.
 * @since 16.04.2018.
 */
public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result;
        int minLenght = Math.min(left.length(), right.length());
        for (int i = 0; i < minLenght; i++) {
            result = Integer.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
