package ru.job4j.tracker;

import org.junit.Test;
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

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenSearchByIdThenTrackerGetsElement() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first", "test1"));
        Item secondItem = tracker.add(new Item("second", "test2"));
        Input input = new StubInput(new String[]{"4", firstItem.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findById(firstItem.getId()).getName(), is(firstItem.getName()));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"2", item.getId(), "update", "descUpdate", "123", "comment", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findById(item.getId()).getName(), is("update"));
    }

    @Test
    public void whenTrackerShowsAllItemsThenSeconItemInListIsCorrect() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first", "test1"));
        Item secondItem = tracker.add(new Item("second", "test2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.getAll()[1].getName(), is("second"));
    }

    @Test
    public void whenDeleteFirstItemThenTrackerContainsOnlySecondItem() {
       Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first", "test1"));
        Item secondItem = tracker.add(new Item("second", "test2"));
        Item thirdItem = tracker.add(new Item("third", "test3"));
        Input input = new StubInput(new String[]{"3", secondItem.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.getAll()[1].getName(), is(thirdItem.getName()));
    }
}
