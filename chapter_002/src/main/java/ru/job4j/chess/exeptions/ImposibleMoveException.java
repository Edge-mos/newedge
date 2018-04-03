package ru.job4j.chess.exeptions;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */

public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String message) {
        super(message);
    }
}
