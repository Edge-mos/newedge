package ru.job4j.loop;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */
public class Counter {
    /**
     *
     * @param start начальная позиция диапазона.
     * @param finish конечная позиция диапазона.
     * @return сумма чётных чисел в заданном диапазоне.
     */
    public int add(int start, int finish) {
        int summOfEven = 0;

        for (int i = start; i <= finish ; i++) {
            if (i % 2 == 0) {
                summOfEven += i;
            }
        }

        return summOfEven;
    }
}
