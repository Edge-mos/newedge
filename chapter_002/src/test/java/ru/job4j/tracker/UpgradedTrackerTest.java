package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.upgraded.Tracker;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Этот класс создан для теста улучшенного класса Tracker из пакета upgraded.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 05.04.2018.
 */
public class UpgradedTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void whenElemenInListThenReturnElement() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123L);
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2", 1234L);
        tracker.add(secondItem);
        Item result = tracker.findById(firstItem.getId());
        assertThat(firstItem.getId(), is(result.getId()));
    }

    @Test
    public void whenElementNotInListThenReturnNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123L);
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2", 1234L);
        Item result = tracker.findById(secondItem.getId());
        System.out.println(secondItem.getId());
        System.out.println(result);
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previousItem = new Item("test1", "testDescription", 123L);
        tracker.add(previousItem);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace(previousItem.getId(), next);
        assertThat(tracker.findById(previousItem.getId()).getName(), is("test2"));
    }

    @Test
    public void whenSearchItemIdInListThenDeleteItemFromList() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123L);
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2", 1234L);
        tracker.add(secondItem);
        Item thirdItem = new Item("test3", "testDescription3", 12345L);
        tracker.add(thirdItem);
        Item fourthItem = new Item("test4", "testDescription4", 4L);
        tracker.add(fourthItem);
        tracker.delete(firstItem.getId());
        assertThat(tracker.getAll().get(0).getId(), is(secondItem.getId()));
    }

    @Test
    public void whenItemsContainsKeyNamesThenReturnList() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123L);
        tracker.add(firstItem);
        Item secondItem = new Item("test1", "testDescription2", 1234L);
        tracker.add(secondItem);
        Item thirdItem = new Item("test2", "testDescription3", 12345L);
        tracker.add(thirdItem);
        Item fourthItem = new Item("test1", "testDescription4", 4L);
        tracker.add(fourthItem);
        List<Item> result = tracker.findByName(firstItem.getName());
        assertThat(result.size(), is(3));
    }
}
