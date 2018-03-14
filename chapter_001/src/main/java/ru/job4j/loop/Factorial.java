package ru.job4j.loop;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */
public class Factorial {
    public long getFactorial(int value) {

        long result = 1;
        int counter = 1;
        while (counter <= value) {
            result *= counter;
            counter++;
        }

        return result;
    }
}
