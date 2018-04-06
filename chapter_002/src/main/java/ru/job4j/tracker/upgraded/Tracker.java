package ru.job4j.tracker.upgraded;
import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Это модифицированная версия Класса Tracker с добавлением ArrayList, вместо массива.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 05.04.2018.
 */

public class Tracker {
    /**
     * Поле - СПИСОК для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * Поле - указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Поле - генерирует уникальный id.
     */
    private static final Random RN = new Random();

    /**
     * Метод, реализующий добавление заявки в хранилище.
     * @param item новая заявка.
     * @return
     */
    public Item add(Item item) {
        item.setId(this.generatedId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки. Так как у заявки уникальности полей,
     * имени и описания. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод нахождения и редактирование(подстановка) заявки по id.
     * @param id Искомого элемента.
     * @param item Новые данные.
     */
    public void replace(String id, Item item) {
        for (Item listItem : this.items) {
            if (listItem.getId().equals(id)) {
                listItem.setName(item.getName());
                listItem.setDescription(item.getDescription());
                listItem.setCreated(item.getCreated());
                listItem.setComment(item.getComment());
                break;
            }
        }
    }

    /**
     * Метод поиска элемента по уникальному id.
     * @param id String id
     * @return Искомый элемент.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаления элемента.
     */
    public void delete(String id) {

        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                this.items.remove(item);
                break;
            }
        }
    }

    /**
     * Метод возвращения списка элементов.
     * @return Возвращает список элементов.
     */
    public List<Item> getAll() {
        return this.items;
    }

    /**
     * Метод поиска элементов по имени.
     * @param key искомое имя элемента.
     * @return возвращает список найденный элементов.
     */
    public List<Item> findByName(String key) {
        List<Item> search = new ArrayList<>();
        for (Item value : this.items) {
            if (value != null && value.getName().equals(key)) {
                search.add(value);
            }
        }
        return search;
    }
}
