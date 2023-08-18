package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        list.add(index, value);
//        ListIterator<T> iterator = list.listIterator();
//        while (iterator.hasNext()) {
//            if (iterator.nextIndex() == index) {
//                iterator.add(value);
//                break;
//            }
//            iterator.next();
//        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        if (index >= list.size()) {
            list.add(value);
        } else {
            list.add(index + 1, value);
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.remove();
                iterator.add(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        removeIf(list, elements::contains);
    }

}