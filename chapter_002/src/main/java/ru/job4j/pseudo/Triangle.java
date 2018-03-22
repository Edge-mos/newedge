package ru.job4j.pseudo;

import ru.job4j.pseudo.interfaces.Shape;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 22.03.2018.
 */

public class Triangle implements Shape {
    @Override
    public String pic() {
        StringBuilder screen = new StringBuilder();
        int weight, height;
        height = 4;
        weight = 2 * height - 1;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < weight; column++) {
                if ((row >= height - column - 1 && row + height - 1 >= column)) {
                    screen.append("+");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return  screen.toString();
    }
}
