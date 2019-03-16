package ru.job4j.addresslist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressList {

    public List<Profile.Address> funcListAddress(Supplier<Stream<Profile.Address>> sup) {
        return sup.get()
                .collect(Collectors.toList());
    }

    public List<Profile.Address> funcUniqueSorted(Supplier<Stream<Profile.Address>> sup) {
        return sup.get()
                .distinct()
                .sorted(Comparator.comparing(Profile.Address::getCity))
                .collect(Collectors.toList());
    }

    /**
     * Универсальная функция под 2 задачи.
     * @param sup Сапплаер, поставляет стрим объектов.
     * @param func Функция, принимает сапплаер и обрабатывает его.
     * @return List<Profile.Address> возвращается после обработки сапплаера в функции.
     */
    public List<Profile.Address> universalFunc(Supplier<Stream<Profile.Address>> sup, Function<Stream<Profile.Address>, List<Profile.Address>> func) {
        return func.apply(sup.get());
    }

    /**
     * Универсальная обобщённая функция. Нужен объект с Comparable.
     * @param sup Сапплаер, поставляет стрим объектов.
     * @param func Функция, принимает сапплаер и обрабатывает его.
     * @param <T> обобщённый объект, поддерживающий интерфейс Comparable.
     * @return
     */
    public static <T extends Comparable<T>>List<T> uniGenFunc(Supplier<Stream<T>> sup, Function<Stream<T>, List<T>> func) {
        return func.apply(sup.get());
    }




}
