package ru.job4j.chess;

import ru.job4j.chess.models.Board;
/**Класс игра и точка входа. Для дальнейшего развития. На данный момент не используется.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void startGame() {
        this.board.init();
        //this.board.figureInitialLocation();
        this.board.showBoard();
    }

//    public static void main(String[] args) {
//        new Game(new Board()).startGame();
//    }
}
