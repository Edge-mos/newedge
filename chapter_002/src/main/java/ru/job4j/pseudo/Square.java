package ru.job4j.pseudo;

import ru.job4j.pseudo.interfaces.Shape;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 22.03.2018.
 */

public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder screen = new StringBuilder();
        int lenght, height;
        lenght = 4;
        height = 4;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < lenght; j++) {
                if ((i != 0 && i != height - 1) && (j > 0 && j < lenght - 1)) {
                    screen.append(" ");
                } else {
                    screen.append("+");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
