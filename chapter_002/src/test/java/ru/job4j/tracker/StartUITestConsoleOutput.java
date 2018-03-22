package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.models.Item;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 21.03.2018.
 */
public class StartUITestConsoleOutput {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("Execute after method");
    }

    @Test
    public void whenTrackerShowsAllItems() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first", "test1"));
        Item secondItem = tracker.add(new Item("second", "test2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(tracker, input).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("     Menu: \n")
                                .append("0. Add new item.\n")
                                .append("1. Show all items.\n")
                                .append("2. Edit item.\n")
                                .append("3. Delete item.\n")
                                .append("4. Find item by id.\n")
                                .append("5. Find items by name.\n")
                                .append("6. Exit Program.\n")
                                .append(System.lineSeparator())
                                .append("-----Show All tasks in list-----\n").append("Item{id='")
                                .append(firstItem.getId()).
                                 append("', name='first', description='test1', created=0, comment='null'}\n")
                                .append(System.lineSeparator()).append("Item{id='").append(secondItem.getId())
                                .append("', name='second', description='test2', created=0, comment='null'}\n")
                                .append(System.lineSeparator())
                                .append("     Menu: \n")
                                .append("0. Add new item.\n")
                                .append("1. Show all items.\n")
                                .append("2. Edit item.\n")
                                .append("3. Delete item.\n")
                                .append("4. Find item by id.\n")
                                .append("5. Find items by name.\n")
                                .append("6. Exit Program.\n")
                                .append("-----EXIT-----\n")
                                .toString()

                        //Это БОЛЬ ))
                )
        );
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first", "test1"));
        Item secondItem = tracker.add(new Item("second", "test2"));
        Item thirdItem = tracker.add(new Item("first", "test2"));
        Input input = new StubInput(new String[]{"5", firstItem.getName(), "6"});
        new StartUI(tracker, input).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("     Menu: \n")
                                .append("0. Add new item.\n")
                                .append("1. Show all items.\n")
                                .append("2. Edit item.\n")
                                .append("3. Delete item.\n")
                                .append("4. Find item by id.\n")
                                .append("5. Find items by name.\n")
                                .append("6. Exit Program.\n")
                                .append("Find by name\n")
                                .append("-----Find by name-----\n")
                                .append("Result: \n")
                                .append("Длинна: 2\n")
                                .append("Item{id='" + firstItem.getId() + "', name='first', description='test1', created=0, comment='null'}\n")
                                .append("Item{id='" + thirdItem.getId() + "', name='first', description='test2', created=0, comment='null'}\n")
                                .append("\n     Menu: \n")
                                .append("0. Add new item.\n")
                                .append("1. Show all items.\n")
                                .append("2. Edit item.\n")
                                .append("3. Delete item.\n")
                                .append("4. Find item by id.\n")
                                .append("5. Find items by name.\n")
                                .append("6. Exit Program.\n")
                                .append("-----EXIT-----\n")
                                .toString()

                )
        );

    }
}
