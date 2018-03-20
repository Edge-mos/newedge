package ru.job4j.tracker;
import ru.job4j.tracker.models.Item;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 19.03.2018.
 */

public class Tracker {
    /**
     * Поле - массив для хранения заявок.
     */
    private final Item[] items = new Item[100];
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
        this.items[position++] = item;
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
        for (int i = 0; i < this.items.length; i++) {
            if(this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - 1 - i);
            }
        }
    }

    /**
     * Метод возвращения списка элементов.
     * @return Возвращает список элементов массива items без null значений.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position ; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод поиска элементов по имени.
     * @param key искомое имя элемента.
     * @return возвращает список найденный элементов.
     */
    public Item[] findByName(String key) {
        Item[] values = getAll();
        Item[] tmp = new Item[getAll().length];
        int count = 0;

        for (Item value : values) {
            if (value.getName().equals(key)) {
                tmp[count] = value;
                count++;
            }
        }
        return Arrays.copyOf(tmp, count);
    }

}
