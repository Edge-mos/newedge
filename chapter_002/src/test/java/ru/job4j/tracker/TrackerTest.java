package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 19.03.2018.
 */

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123l);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenElemenInListThenReturnElement() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123l);
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2", 1234l);
        tracker.add(secondItem);
        Item result = tracker.findById(firstItem.getId());
        assertThat(firstItem.getId(), is(result.getId()));
    }

    @Test
    public void whenElementNotInListThenReturnNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123l);
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2", 1234l);
        Item result = tracker.findById(secondItem.getId());
        System.out.println(secondItem.getId());
        System.out.println(result);
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previousItem = new Item("test1", "testDescription", 123l);
        tracker.add(previousItem);
        Item next = new Item("test2","testDescription2",1234L);
        tracker.replace(previousItem.getId(), next);
        assertThat(tracker.findById(previousItem.getId()).getName(), is("test2"));
    }

    @Test
    public void whenSearchItemIdInListThenDeleteItemFromList() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123l);
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2", 1234l);
        tracker.add(secondItem);
        Item thirdItem = new Item("test3", "testDescription3", 12345l);
        tracker.add(thirdItem);
        Item fourthItem = new Item("test4", "testDescription4", 4l);
        tracker.add(fourthItem);
        tracker.delete(firstItem.getId());
        assertThat(tracker.getAll()[0].getId(), is(secondItem.getId()));
    }

    @Test
    public void whenItemsContainsKeyNamesThenReturnList() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123l);
        tracker.add(firstItem);
        Item secondItem = new Item("test1", "testDescription2", 1234l);
        tracker.add(secondItem);
        Item thirdItem = new Item("test2", "testDescription3", 12345l);
        tracker.add(thirdItem);
        Item fourthItem = new Item("test1", "testDescription4", 4l);
        tracker.add(fourthItem);
        Item[] result = tracker.findByName(firstItem.getName());
        assertThat(result.length, is(3));
    }

}
