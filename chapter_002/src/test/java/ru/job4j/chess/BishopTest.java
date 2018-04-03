package ru.job4j.chess;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import ru.job4j.chess.interfaces.implemented.Figure;
import ru.job4j.chess.models.Bishop;
import ru.job4j.chess.models.Board;
import ru.job4j.chess.models.Cell;

import java.util.Arrays;
/**Добавленно отображение возможных ходов в консоли.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */
public class BishopTest {
    @Test
    public void bishopHas11Moves() {
        Board board = new Board();
        board.init();
        Figure bishop = new Bishop(new Cell(5, 3), "white");
        board.add(bishop);
        board.setMovesOnBoard(bishop, new Cell(3, 1));
        board.showBoard();
        Cell[] res = bishop.way(new Cell(5, 3), new Cell(3, 1));
        Cell[] exp = {
                new Cell(6, 2),
                new Cell(6, 4),
                new Cell(7, 1),
                new Cell(7, 5),
                new Cell(4, 2),
                new Cell(4, 4),
                new Cell(3, 1),
                new Cell(3, 5),
                new Cell(2, 0),
                new Cell(2, 6),
                new Cell(1, 7)
        };
        String result = Arrays.toString(res);
        String expected = Arrays.toString(exp);
        assertThat(result, is(expected));
    }
    @Test
    public void  bishopHas7Moves() {
        Board board = new Board();
        board.init();
        Figure bishop = new Bishop(new Cell(2, 0), "white");
        board.add(bishop);
        board.setMovesOnBoard(bishop, new Cell(3, 1));
        board.showBoard();
        Cell[] res = bishop.way(new Cell(2, 0), new Cell(3, 1));
        Cell[] exp = {
                new Cell(3, 1),
                new Cell(4, 2),
                new Cell(5, 3),
                new Cell(6, 4),
                new Cell(7, 5),
                new Cell(1, 1),
                new Cell(0, 2)
        };
        String result = Arrays.toString(res);
        String expected = Arrays.toString(exp);
        assertThat(result, is(expected));
    }

}
