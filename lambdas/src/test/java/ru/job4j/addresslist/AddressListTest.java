package ru.job4j.addresslist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AddressListTest {

    private List<Profile> profiles = Arrays.asList(
            new Profile("Ivan", "Moscow", "Tverskaya", 1, 1),
            new Profile("Suzan", "Moscow", "Tverskaya", 1, 1),
            new Profile("Olga", "Sarov", "BombStreet", 3, 45),
            new Profile("Nickolay", "Saint-Petersburg", "Rubinshtein", 5, 34)
    );

    @Test
    public void whenCollectCustomersAddresses() {
        AddressList addressList = new AddressList();
        List<Profile.Address> expected = new ArrayList<>(Arrays.asList(
                new Profile("Ivan", "Moscow", "Tverskaya", 1, 1).getAddress(),
                new Profile("Suzan", "Moscow", "Tverskaya", 1, 1).getAddress(),
                new Profile("Olga", "Sarov", "BombStreet", 3, 45).getAddress(),
                new Profile("Nickolay", "Saint-Petersburg", "Rubinshtein", 5, 34).getAddress()
        ));
        List<Profile.Address> result = addressList.funcListAddress(() -> this.profiles.stream().map(Profile::getAddress));
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectUniqueAndSorted() {
        AddressList addressList = new AddressList();
        List<Profile.Address> expected = new ArrayList<>(Arrays.asList(
                new Profile("Ivan", "Moscow", "Tverskaya", 1, 1).getAddress(),
                new Profile("Nickolay", "Saint-Petersburg", "Rubinshtein", 5, 34).getAddress(),
                new Profile("Olga", "Sarov", "BombStreet", 3, 45).getAddress()
        ));
        List<Profile.Address> result = addressList.funcUniqueSorted(() -> this.profiles.stream().map(Profile::getAddress));
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectCustomersAddressesByUniversalFunc() {
        AddressList addressList = new AddressList();
        List<Profile.Address> expected = new ArrayList<>(Arrays.asList(
                new Profile("Ivan", "Moscow", "Tverskaya", 1, 1).getAddress(),
                new Profile("Suzan", "Moscow", "Tverskaya", 1, 1).getAddress(),
                new Profile("Olga", "Sarov", "BombStreet", 3, 45).getAddress(),
                new Profile("Nickolay", "Saint-Petersburg", "Rubinshtein", 5, 34).getAddress()
        ));

        Supplier<Stream<Profile.Address>> sup = () -> this.profiles
                .stream()
                .map(Profile::getAddress);

        Function<Stream<Profile.Address>, List<Profile.Address>> func = addressStream -> addressStream
                .collect(Collectors.toList());

        List<Profile.Address> result = addressList.universalFunc(sup, func);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectUniqueAndSortedByUniversalFunc() {
        AddressList addressList = new AddressList();
        List<Profile.Address> expected = new ArrayList<>(Arrays.asList(
                new Profile("Ivan", "Moscow", "Tverskaya", 1, 1).getAddress(),
                new Profile("Nickolay", "Saint-Petersburg", "Rubinshtein", 5, 34).getAddress(),
                new Profile("Olga", "Sarov", "BombStreet", 3, 45).getAddress()
        ));

        Supplier<Stream<Profile.Address>> sup = () -> this.profiles
                .stream()
                .map(Profile::getAddress);

        Function<Stream<Profile.Address>, List<Profile.Address>> func = addressStream -> addressStream
                .distinct()
                .sorted(Comparator.comparing(Profile.Address::getCity))
                .collect(Collectors.toList());

        List<Profile.Address> result = addressList.universalFunc(sup, func);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectUniqueAndSortedByUniversalGenFunc() {
        AddressList addressList = new AddressList();
        List<Profile.Address> expected = new ArrayList<>(Arrays.asList(
                new Profile("Ivan", "Moscow", "Tverskaya", 1, 1).getAddress(),
                new Profile("Nickolay", "Saint-Petersburg", "Rubinshtein", 5, 34).getAddress(),
                new Profile("Olga", "Sarov", "BombStreet", 3, 45).getAddress()
        ));

        Supplier<Stream<Profile.Address>> sup = () -> this.profiles
                .stream()
                .map(Profile::getAddress);

        Function<Stream<Profile.Address>, List<Profile.Address>> func = addressStream -> addressStream
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        List<Profile.Address> result = AddressList.uniGenFunc(sup, func);

        assertThat(result, is(expected));
    }



}