package ru.job4j.addresslist;

import java.util.Objects;

public class Profile {
    private final String name;
    private Address address;

    public Profile(String name, String city, String street, int home, int apartment) {
        this.name = name;
        this.address = new Address(city, street, home, apartment);
    }

    final class Address implements Comparable{
        private String city;
        private String street;
        private int home;
        private int apartment;

        private Address(String city, String street, int home, int apartment) {
            this.city = city;
            this.street = street;
            this.home = home;
            this.apartment = apartment;
        }

        public String getCity() {
            return this.city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return home == address.home &&
                    apartment == address.apartment &&
                    Objects.equals(city, address.city) &&
                    Objects.equals(street, address.street);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, street, home, apartment);
        }

        @Override
        public String toString() {
            return String.format("City: %s Street: %s Home: %d Apartment: %d",
                    this.city,
                    this.street,
                    this.home,
                    this.apartment);
        }

        @Override
        public int compareTo(Object o) {
            Address address = (Address) o;
            return this.city.compareTo(address.city);
        }
    }

    public Address getAddress() {
        return this.address;
    }

    public String getContactCity() {
        return this.getAddress().city;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n",
                this.name
                        .concat("\n")
                        .concat(this.address.toString()));
    }
}
