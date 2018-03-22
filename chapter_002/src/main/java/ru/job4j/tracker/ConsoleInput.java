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
}
