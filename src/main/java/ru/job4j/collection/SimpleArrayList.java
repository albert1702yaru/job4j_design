package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity == 0 ? 10 : capacity];
        size = 0;
    }

    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public void add(T value) {
        container[size++] = value;
        if (size >= container.length) {
            grow();
        }
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T value = this.get(index);
        container[index] = newValue;
        return value;
    }

    @Override
    public T remove(int index) {
        T value = this.get(index);
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[size-- - 1] = null;
        modCount++;
        return value;
    }

    @Override
    public T get(int index) {
        return container[Objects.checkIndex(index, size)];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }
        };
    }
}