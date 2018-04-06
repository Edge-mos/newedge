package ru.job4j.tracker.upgraded;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;
import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Улучшенный класс! Добавлен ArrayList вместо массива.
 * Реализует альтернативное меню, каждый пунк меню - отдельный объект, имплементирующий интерфейс UserAction
 * каждый объект - внутренний класс, кроме класса EditItem - он внешний класс в том же пакете, класс FindById - внутренний статический.
 * В каждом классе 3 метода.
 * void execute() - основное тело метода и класса.
 * int key() - для отображения номера String info().
 * String info() - для отображения информации в массиве.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 05.04.2018.
 */


class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Choise task for Editting: ");
        new MenuTracker.ShowAllItems().execute(input, tracker);
        String itemId = input.ask("Enter Item's id to Edit: ");
        for (Item item : tracker.getAll()) {
            if (item != null && item.getId().equals(itemId)) {
                System.out.println(item);
                String name = input.ask("Edit name: ");
                String description = input.ask("Edit description: ");
                long time = Long.valueOf(input.ask("Edit time: "));
                String comment = input.ask("Enter comment: ");
                item.setName(name);
                item.setDescription(description);
                item.setCreated(time);
                item.setComment(comment);
                System.out.println("After editing: " + item);
                break;
            }
        }
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    //private int index = 0;
    /**
     * Массив для визуального меню.
     */
    private List<UserAction> actions = new ArrayList<>();
    //private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Регистрация объектов в массиве.
     */
    public void fillActions() {
        this.addActions(new AddItem(0, "Add new Item."));
        this.addActions(new MenuTracker.ShowAllItems(1, "Show all items."));
        this.addActions(new EditItem(2, "Edit Item."));
        this.addActions(new DeleteItem(3, "Delete Item from Tracker."));
        this.addActions(new FindById(4, "Find Item by id."));
        this.addActions(new FindByName(5, "Find by name."));
        this.addActions(new Exit(6, "Exit Program."));
    }

    /**
     * обращается в массив по ключу, запускает метод execute() для каждого объекта в массиве.
     * @param key ключ, пользователь вводит с клавиатуры.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * показывает визуальное меню, запускает метод info() для каждого объекта
     */
    public void show() {
        for (UserAction action : this.actions) {
                System.out.println(action.info());
        }
    }

    /**
     * Метод для определения диапазона ключей, для того что бы подставить в перегруженный метод int ask()
     * @return Диапазон значений.
     */
//    public int[] getRange() {
//
//        int[] result = new int[this.actions.length];
//        for (int i = 0; i < this.actions.length; i++) {
//            result[i] = this.actions[i].key();
//        }
//        return result;
//    }

    /**
     * Метод для добавления пунктов меню.
     * @param action Добавляет объект типа UserAction, который реализован как внутренний класс.
     */
    public void addActions(UserAction action) {
        this.actions.add(action);
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter task's name: ");
            String description = input.ask("Enter description: ");
            tracker.add(new Item(name, description));
        }

    }

    public static class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        public ShowAllItems() {
            super();
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] allList = tracker.getAll();
            for (Item item : allList) {
                System.out.println(item);
                System.out.println();
            }
        }
    }

    private static class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String answer = input.ask("Enter task's id: ");
            Item wantedItem = tracker.findById(answer);
            System.out.println(wantedItem + "\n");
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Choise task for Delete: ");
            new MenuTracker.ShowAllItems().execute(input, tracker);
            String itemId = input.ask("Enter Item's id to Delete: ");

            for (Item item : tracker.getAll()) {
                if (item != null && item.getId().equals(itemId)) {
                    System.out.println(item);
                    tracker.delete(item.getId());
                    System.out.println("task with id: " + item.getId() + " was removed from list\n");
                    break;
                }
            }
        }
    }

    private class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----Find by name-----");
            String taskName = input.ask("Enter name of the task(s)");
            Item[] tasks = tracker.findByName(taskName);
            System.out.println("Result: ");
            System.out.println("Длинна: " + tasks.length);
            for (Item task : tasks) {
                System.out.println(task);
            }
            System.out.println();
        }
    }

    private class Exit extends BaseAction {

        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----Exit-----");
            System.exit(0);
        }
    }
}
