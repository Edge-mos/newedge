package ru.job4j.pseudo;

import ru.job4j.pseudo.interfaces.Shape;

/**
 * Класс Paint использует паттерн Strategy.
 * В его методе draw(Shape shape) передаётся объект типа Shape.
 * Есть несколько объектов, которые реализуют интерфейс Shape.
 * У этих объектов разная реализация (стратегия).
 * В зависимости от переданного объекта в метод, будет использована своя стратегия.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 22.03.2018.
 */

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
