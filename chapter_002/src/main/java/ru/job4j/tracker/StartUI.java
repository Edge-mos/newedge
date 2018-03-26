package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.models.Item;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 21.03.2018.
 */

public class StartUI {
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Конструктор, инициализирующй поля.
     * @param tracker хранилище заявок.
     * @param consoleInput ввод пользователя.
     */
    public StartUI(Tracker tracker, Input consoleInput) {
        this.tracker = tracker;
        this.input = consoleInput;
    }

    public void showMenu() {
        System.out.println("     Menu: ");
        System.out.println("0. Add new item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    public void init() {
        boolean exit = false;
        showMenu();

        do {
            String answer = this.input.ask("Select option: ");
            switch (answer) {
                case "0":
                    createItem();
                    showMenu();
                    break;
                case "1":
                    showAllItems();
                    showMenu();
                    break;
                case "2":
                    editItem();
                    showMenu();
                    break;
                case "3":
                    deleteItem();
                    showMenu();
                    break;
                case "4":
                    System.out.println("\n-----Find by id-----");
                    findById();
                    showMenu();
                    break;
                case "5":
                    System.out.println("Find by name");
                    findName();
                    showMenu();
                    break;
                case "6":
                    System.out.println("-----EXIT-----");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong option, try again\n");
                    showMenu();
            }
        } while (!exit);
    }

    private void createItem() {
        System.out.println("\n-----Enter new task-----");
        String name = this.input.ask("Enter task's name: ");
        String description = this.input.ask("Enter description: ");
        Item createdItem = new Item(name, description);
        this.tracker.add(createdItem);
        System.out.println("New task with id: " + createdItem.getId() + " added!\n");
    }

    private void showAllItems() {
        System.out.println("\n-----Show All tasks in list-----");
        Item[] allList = this.tracker.getAll();
        for (Item item : allList) {
            System.out.println(item);
            System.out.println();
        }
    }

    private void editItem() {
        System.out.println("\n-----Edit task-----");
        System.out.println("Choise task for Editting: ");
        Item editableItem = findById();
        String name = this.input.ask("Edit name: ");
        String description = this.input.ask("Edit description: ");
        long time = Long.valueOf(this.input.ask("Edit time: "));
        String comment = this.input.ask("Enter comment: ");
        Item tmp = new Item(name, description, time, comment);
        this.tracker.replace(editableItem.getId(), tmp);
        System.out.println("After editing: \n" + this.tracker.findById(editableItem.getId()) + "\n");
    }

    private void deleteItem() {
        System.out.println("-----Delete task-----");
        System.out.println("Choise task for Delete: ");
        Item deleteItem = findById();
        this.tracker.delete(deleteItem.getId());
        System.out.println("task with id: " + deleteItem.getId() + " was removed from list\n");
    }

    private Item findById() {
        String answer = this.input.ask("Enter task's id: ");
        Item wantedItem = this.tracker.findById(answer);
        System.out.println(wantedItem + "\n");
        return wantedItem;
    }

    private void findName() {
        System.out.println("-----Find by name-----");
        String taskName = this.input.ask("Enter name of the task(s)");
        Item[] tasks = this.tracker.findByName(taskName);
        System.out.println("Result: ");
        System.out.println("Длинна: " + tasks.length);
        for (Item task : tasks) {
            System.out.println(task);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(new Tracker(), input).init();
    }
}
