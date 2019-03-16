package ru.job4j.banklambda.models;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.04.2018.
 */
public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public Account(String requisites) {
        this(0.0, requisites);
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    @Override
    public int hashCode() {
        return requisites != null ? requisites.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Account{"
                +
                "value=" + value
                +
                ", requisites='" + requisites + '\''
                +
                '}';
    }
}
