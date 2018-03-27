package ru.job4j.tracker;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.models.Item;

import java.util.Arrays;

/**Этот класс ВТОРАЯ версия класса StartUI, демонстрирует работу, основанную на внутренних классах.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 26.03.2018.
 */

public class StartUIVerTwo {
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Реализация меню посредством вложенных классов.
     */
    private MenuTracker menu;
    /**
     * Диапазон заявок, для перегруженного метода int ask().
     */
    private int[] menuRange;

    /**
     * Конструктор, инициализирующй поля.
     * @param tracker хранилище заявок.
     * @param consoleInput ввод пользователя.
     */
    public StartUIVerTwo(Tracker tracker, Input consoleInput) {
        this.tracker = tracker;
        this.input = consoleInput;
        this.menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        this.menuRange = menu.getRange();
    }

    public void init() {
       do {
           menu.show();
           //int key = Integer.parseInt(input.ask("Select option: ")); замена метода String ask()на перегруженный int ask()
           menu.select(input.ask("Select option: ", this.menuRange));
       } while (!"y".equals(input.ask("Exit y/n: ").toLowerCase()));
    }

//    public static void main(String[] args) {
//        new StartUIVerTwo(new Tracker(), new ValidateInput()).init();
//    }


}
