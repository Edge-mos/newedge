package ru.job4j.calculator;

/**
 * Программа расчёта идеального веса.
 */
public class Fit {

    /**
     * Коэффициент для веса.
     */
    private final double multiplier = 1.15;

    /**
     * Идеальный вес для мужчины.
     * @param height рост в сантиметрах.
     * @return вес в кг.
     */
    public final double manWeight(final double height) {
        final int correctionHeight = 100;
        return (height - correctionHeight) * this.multiplier;
    }

    /**
     * Идеальный вес для женщины.
     * @param height рост в сантиметрах.
     * @return вес в кг.
     */
    public final double womanWeight(final double height) {
        final int correctionHeight = 110;
        return (height - correctionHeight) * this.multiplier;
    }
}
