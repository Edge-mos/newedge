package ru.job4j.chess.models;

import ru.job4j.chess.exeptions.ImposibleMoveException;
import ru.job4j.chess.interfaces.implemented.Figure;
import java.util.Arrays;
/**Полностью реализованная модель Bishop, требуемая в задаче.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */

public class Bishop extends Figure {

    public Bishop(Cell position, String color) {
        super(position, color);
    }

    /**
     * Рассчитывает ходы фигуры в зависимости от её положения на доске, расчитывает сначала нижние диагонали, потом верхние.
     * @param source Положение самой фигуры на доске.
     * @param desc Клетка, куда нужно совершить(если возможно) ход.
     * @return Если возможно ходить с текущей клетки в целевую клетку, возвращает массив из ячеек возможного хода.
     * @throws ImposibleMoveException Если ходить невозможно, то выкидывает исключение.
     */
    @Override
    public Cell[] way(Cell source, Cell desc) throws ImposibleMoveException {
        boolean canMove = false;
        Cell[] moves = new Cell[15];
        int index = 0;
        int startX = source.getCoordinateX();
        int startY = source.getCoordinateY();

        //нижние диагонали.
        if (source.getCoordinateX() < 7) {

            int tmpLeftY = startY - 1;
            int tmpRightY = startY + 1;

            for (int i = startX + 1; i < 8; i++) {
                Cell left = new Cell(i, tmpLeftY);
                Cell right = new Cell(i, tmpRightY);

                if (tmpLeftY >= 0) {
                    moves[index++] = left;
                    tmpLeftY--;
                }

                if (tmpRightY < 8) {
                    moves[index++] = right;
                    tmpRightY++;
                }
            }
        }
        // верхние диагонали.
        if (source.getCoordinateX() > 0) {
            int tmpLeftY = startY - 1;
            int tmpRightY = startY + 1;

            for (int i = startX - 1; i >= 0; i--) {
                Cell left = new Cell(i, tmpLeftY);
                Cell right = new Cell(i, tmpRightY);

                if (tmpLeftY >= 0) {
                    moves[index++] = left;
                    tmpLeftY--;
                }

                if (tmpRightY < 8) {
                    moves[index++] = right;
                    tmpRightY++;
                }
            }
        }

        for (Cell move : moves) {
            if (move != null && desc.getCoordinateX() == move.getCoordinateX() && desc.getCoordinateY() == move.getCoordinateY()) {
                canMove = true;
                break;
            }
        }

        if (canMove) {
            return Arrays.copyOf(moves, index);
        } else {
            throw new ImposibleMoveException("Can't move to: " + desc);
        }
    }

    /**
     * Возвращает ту же фигуру, только с новыми координатами, идёт пересозднание объекта.
     * @param desc Клетка назначения.
     * @return Возврат нового объекта фигуры, поля координат фигуры final.
     */
    @Override
    public Figure copy(Cell desc) {
        return new Bishop(desc, this.color);
    }

    /**
     * Выдаёт символ иникода взависимости от цвета.
     * @return
     */
    @Override
    public String paint() {
        if (color.equals("white")) {
            return "\u2657";
        } else {
            return "\u265D";
        }
    }
}
