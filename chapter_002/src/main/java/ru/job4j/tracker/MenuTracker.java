package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;
import ru.job4j.tracker.models.Item;

/**
 * Реализует альтернативное меню, каждый пунк меню - отдельный объект, имплементирующий интерфейс UserAction
 * каждый объект - внутренний класс, кроме класса EditItem - он внешний класс в том же пакете, класс FindById - внутренний статический.
 * В каждом классе 3 метода.
 * void execute() - основное тело метода и класса.
 * int key() - для отображения номера String info().
 * String info() - для отображения информации в массиве.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 26.03.2018.
 */


class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the new Item.");
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    /**
     * Массив для визуального меню.
     */
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Регистрация объектов в массиве.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit();
    }

    /**
     * обращается в массив по ключу, запускает метод execute() для каждого объекта в массиве.
     * @param key ключ, пользователь вводит с клавиатуры.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);

    }

    /**
     * показывает визуальное меню, запускает метод info() для каждого объекта
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Метод для определения диапазона ключей, для того что бы подставить в перегруженный метод int ask()
     * @return
     */
    public int[] getRange() {
        int[] result = new int[this.actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            result[i] = this.actions[i].key();
        }
        return result;
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter task's name: ");
            String description = input.ask("Enter description: ");
            tracker.add(new Item(name, description));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new Item.");
        }
    }

    public static class ShowAllItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] allList = tracker.getAll();
            for (Item item : allList) {
                System.out.println(item);
                System.out.println();
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show All Items in Tracker.");
        }
    }

    private static class FindById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String answer = input.ask("Enter task's id: ");
            Item wantedItem = tracker.findById(answer);
            System.out.println(wantedItem + "\n");
            //return wantedItem;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find Item by id.");
        }
    }

    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete Item from Tracker.");
        }
    }

    private class FindByName implements UserAction {

        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find by name.");
        }
    }

    private class Exit implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----Exit-----");
            System.exit(0);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program.");
        }
    }



}
