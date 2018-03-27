package ru.job4j.tracker;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 21.03.2018.
 */

import ru.job4j.tracker.interfaces.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Перегруженный метод ask() для int значений
     * @param question вопрос для ввода.
     * @param range принимает массив для определения входящих в него индексов и для осуществления проверки.
     * @return если значение в пределах массива - возвращает индекс, если нет - ошибка, возвращает - 1.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutExeption("Out of menu range");
        }
    }
}
