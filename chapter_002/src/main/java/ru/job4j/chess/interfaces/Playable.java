package ru.job4j.chess.interfaces;

import ru.job4j.chess.models.Cell;
import ru.job4j.chess.interfaces.implemented.Figure;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */

public interface Playable {
    Cell[] way(Cell source, Cell desc);
    Figure copy(Cell desc);
    String getSymbol();
    String paint();

}
