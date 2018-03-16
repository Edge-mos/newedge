package ru.job4j.array;

/**
 * Класс проверяет содержится ли слово в другом слове
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */


public class StringInWord {

    public boolean contains(String origin, String sub) {
        boolean result = false;
        char[] initial = origin.toCharArray();
        char[] subString = sub.toCharArray();
        
        for (int i = 0; i < initial.length; i++) {
            int sequence = subString.length;
            for (int j = 0; j < subString.length; j++) {

                if (initial[i] != subString[j]) {
                    break;
                } else {
                    sequence--;
                    i++;
                }
            }

            if (sequence == 0) {
                result = true;
                break;
            }
        }

        return result;
    }
}
