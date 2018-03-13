package ru.job4j.calculator;

/**
 *  Конвертер вылюты.
 */
public class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public final int rubleToEuro(final int value) {
        final int cource = 70;
        return value / cource;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары.
     */
    public final int rubleToDollar(final int value) {
        final int cource = 60;
        return value / cource;
    }


    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public final int euroToRuble(final int value) {
       final int cource = 70;
        return value * cource;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public final int dollarToRuble(final int value) {
        final int cource = 60;
        return value * cource;
    }
}
