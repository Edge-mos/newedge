package ru.job4j.chess.models;

import ru.job4j.chess.interfaces.implemented.Figure;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */
public class Pawn extends Figure {

    public Pawn(Cell position, String color) {
        super(position, color);
    }


    @Override
    public Cell[] way(Cell source, Cell desc) {
        return new Cell[0];
    }

    @Override
    public Figure copy(Cell desc) {
        return new Pawn(desc, this.color);
    }

    @Override
    public String paint() {
        if (color.equals("white")) {
            return "\u2659";
        } else {
            return "\u265F";
        }
    }
}
