package ru.job4j.condition;

/**
 * Класс Точка.
 * @author vyamnikov (Androedge@gmail.com).
 * @since 13.03.2018.
 * @version 2.0.
 */
public class Point {

    /**
     * Координаты точки (x и y).
     */
    private int x, y;

    /**
     * Конструктор класса Point.
     * @param x координата.
     * @param y координата.
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние от заданной точки(точка а) и до второй точки.
     * @param that Тип Точка (вторая точка до которой считается расстояние).
     * @return Расстояние от заданной точки до второй точки.
     */
    public final double distanceTo(final Point that) {
        // Точка А - это текущая точка. К ней мы обращаемся через оператор this.
        Point a = this;
        // Точка В - это входящая точка. К ней мы можем обратиться
        // напрямую через имя переменной that.
        // или для удоства мы создали новую переменню b
        // и к ней присвоили переменную that.
        Point b = that;

        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;
        double result = Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
        return result;
    }

    /**
     * Main.
     * @param args параметры строки.
     */
    public static void main(final String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}

