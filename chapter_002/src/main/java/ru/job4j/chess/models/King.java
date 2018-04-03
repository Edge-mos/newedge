package ru.job4j.chess.models;

import ru.job4j.chess.interfaces.implemented.Figure;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */
public class King extends Figure {

    public King(Cell position, String color) {
        super(position, color);
    }

    @Override
    public Cell[] way(Cell source, Cell desc) {
        return new Cell[0];
    }

    @Override
    public Figure copy(Cell desc) {
        return new King(desc, this.color);
    }

    @Override
    public String paint() {
        if (color.equals("white")) {
            return "\u2654";
        } else {
            return "\u265A";
        }
    }
}
