package ru.job4j.chess;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import ru.job4j.chess.interfaces.implemented.Figure;
import ru.job4j.chess.models.*;
/**Добавленно отображение на консоли. Целевая фигура белый слон, меняет своё положение на доске.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */
public class BoardTest {
    @Test
    public void whenWhiteBishopCanMoveThanTrueAndWhiteBishopMoveToNewPosition() {
        boolean result;
        Board board = new Board();
        board.init();
        Figure bishop = new Bishop(new Cell(5, 3), "white");
        Figure rook = new Rook(new Cell(0, 0), "black");
        Figure queen = new Queen(new Cell(7, 3), "white");
        Figure knight = new Knight(new Cell(2, 2), "black");
        Figure whiteKnight = new Knight(new Cell(6, 5), "white");
        board.add(bishop);
        board.add(rook);
        board.add(queen);
        board.add(knight);
        board.add(whiteKnight);
        System.out.println("\nBEFORE:");
        board.showBoard();
        System.out.println("\nAFTER:");
        result = board.move(new Cell(5, 3), new Cell(3, 1));
        assertThat(result, is(true));
    }
}
