package util;

import java.util.Arrays;

public class UniversalArrayImpl<T> implements UniversalArray<T> {
    private Object[] array;

    public UniversalArrayImpl(T[] a) {
        array = a;
    }

    public UniversalArrayImpl() {
        this.array = new Object[]{};
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public void add(T element) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = element;
    }

    @Override
    public void addAll(Object[] elements) {
        for (var element : elements) {
            add((T) element);
        }
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArray = new Object[array.length - 1];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }

        array = newArray;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        int size = size();
        if (a.length < size)
            return Arrays.copyOf(array, size,
                    (Class<? extends E[]>) a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length, Object[].class);
    }


}
