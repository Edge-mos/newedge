package ru.job4j.tracker;
/**Этот класс сделан для отлова ошибки выхода за пределы массива-меню. Основан на классе RuntimeException.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 27.03.2018.
 */

public class MenuOutExeption extends RuntimeException {
    public MenuOutExeption(String message) {
        super(message);
    }
}
