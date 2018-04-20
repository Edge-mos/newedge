package ru.job4j.bank.models;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.04.2018.
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public User(String passport) {
        this ("", passport);
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    @Override
    public int hashCode() {
        return passport != null ? passport.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='" + name + '\''
                +
                ", passport='" + passport + '\''
                +
                '}';
    }

}
