package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < left.length(); i++) {
            result = Integer.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }

            result = (left.length() == right.length()) ? (0) : (-1);
        }
        return result;
    }
}
