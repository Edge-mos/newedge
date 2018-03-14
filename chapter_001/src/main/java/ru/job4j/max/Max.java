package ru.job4j.max;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */

public class Max {
    /**
     * Сравнивает 2 числа и возвращает большее.
     * @param first первое число
     * @param second второе число
     * @return наибольшее из 2 чисел
     */
    public int maxOfTwoIntegers(int first, int second) {
        return (first > second) ? first : second;
    }

    public int maxOfThreeIntegers(int first, int second, int third) {
        int temp = this.maxOfTwoIntegers(first, second);

        return this.maxOfTwoIntegers(temp, third);
    }
}
