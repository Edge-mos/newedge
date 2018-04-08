package ru.job4j.search.sort;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Сравнивает ЭТОТ объект с входящим.
     * @param o объект сравнения
     * @return результат сравнения.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='" + name + '\''
                +
                ", age=" + age
                +
                '}';
    }
}
