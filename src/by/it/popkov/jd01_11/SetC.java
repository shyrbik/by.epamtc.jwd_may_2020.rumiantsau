package by.it.popkov.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (check(t) < 0) {
            if (size >= elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size] = t;
            size += 1;
        }
        return false;
    }

    private int check(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        int index = check(o);
        if (index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            elements[size] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String comma = "";
        for (int i = 0; i < size; i++) {
            sb.append(comma).append(elements[i]);
            comma = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    ///----------------------------------Fictive------------------------

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
