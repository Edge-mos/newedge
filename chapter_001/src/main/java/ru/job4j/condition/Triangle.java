package ru.job4j.condition;
import static java.lang.Math.sqrt;

/**
 * Вычисляет площадь треугольника по формуле Герона.
 * Треугольник образуется соединением отрезками трех точек, не лежащих на одной прямой.
 * При этом точки называются вершинами треугольника, а отрезки - его сторонами.
 * Площадь тругольника по формуле Герона равна корню из произведения разностей полупериметра треугольника (p)
 * и каждой из его сторон (a, b, c).
 * Порядок выполнения:
 * 1) Рассчитать длины сторон треугольника по координатам точек на плоскости.
 * 2) Определить существует ли треугольник с такими сторонами.
 * 3) Вычислить полупериметр.
 * 4) Вычислить площадь треугольника по формуле Герона.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */

public class Triangle {

    private Point a, b, c;

    /**
     * Конструктор класса Triangle.
     * @param a объект класса Point.
     * @param b объект класса Point.
     * @param c объект класса Point.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double triangleArea = -1;

        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);

        if (this.exist(ab, ac, bc)) {
            double p = period(ab, ac, bc);
            triangleArea = sqrt(p * ((p - ab) * (p - ac) * (p - bc)));
        }

        return triangleArea;
    }

    /**
     * Вычисляет существует ли треугольник с заданными сторонами.
     * @param ab сторона треугольника.
     * @param ac сторона треугольника.
     * @param bc сторона треугольника.
     * @return boolean.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc && ab + bc > ac && ac + bc > ab;
    }

    /**
     * Вычисляет полупериметр треугольника.
     * @param ab ab расстояние между точками a b
     * @param ac ac расстояние между точками a c
     * @param bc bc расстояние между точками b c
     * @return double полупериметр
     */
    private double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
}
