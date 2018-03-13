package ru.job4j.calculator;
/**
 * Калькулятор.
 */
public class Calculator {
    /**
     * переменная результат.
     */
    private double result;

    /**
     * Сложение.
     * @param first значение.
     * @param second значение.
     */
    public final void add(final double first, final double second) {
        this.result = first + second;
    }

    /**
     * Вычитание.
     * @param first значение.
     * @param second значение.
     */
    public final void subtract(final double first, final double second) {
        this.result = first - second;
    }

    /**
     * Деление.
     * @param first значение.
     * @param second значение.
     */
    public final void div(final double first, final double second) {
        this.result = first / second;
    }

    /**
     * Умножение.
     * @param first значение.
     * @param second значение.
     */
    public final void multiple(final double first, final double second) {
        this.result = first * second;
    }

    /**
     * Получение результата.
     * @return результат.
     */
    public final double getResult() {
        return this.result;
    }
}
