package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;

public class SimpleArraySet<T> implements SimpleSet<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        int a = set.size();
        if (!contains(value)) {
            set.add(value);
        }
        return a != set.size();
    }

    @Override
    public boolean contains(T value) {
        for (T t : set) {
            if (value == t) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}