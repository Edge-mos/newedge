package ru.job4j.chess.interfaces.implemented;

import ru.job4j.chess.interfaces.Playable;
import ru.job4j.chess.models.Cell;
/**Абстрактный класс, реализующий интерфейс Playable.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */

public abstract class Figure implements Playable {
    protected final Cell position;
    protected String name;
    protected final String color;
    protected String symbol;

    protected Figure(Cell position, String color) {
        this.position = position;
        this.color = color;
        this.symbol = this.getSymbol();
        this.name = this.getClass().getName().substring(22);
    }

    public Cell getPosition() {
        return position;
    }

    public abstract Cell[] way(Cell source, Cell desc);


    public  String getSymbol() {
        return paint();
    }

    @Override
    public String toString() {
        return "Figure{"
                +
                "position : " + this.position
                +
                ", name='" + this.name + '\''
                +
                ", color='" + this.color + '\''
                +
                '}';
    }

}
