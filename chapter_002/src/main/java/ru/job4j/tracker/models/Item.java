package ru.job4j.tracker.models;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 19.03.2018.
 */


public class Item {
    private String id;
    private String name;
    private String description;
    private long created;
    private String comment;

    public Item() {
    }

    public Item(String name, String description, long created) {
        this(name, description, created,null);
    }

    public Item(String name, String description, long created, String comment) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", comment='" + comment + '\'' +
                '}';
    }
}
