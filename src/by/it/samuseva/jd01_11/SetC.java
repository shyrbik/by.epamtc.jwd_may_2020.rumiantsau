package by.it.samuseva.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {
    private int size = 0;
    private T[] elements = (T[]) new Object[]{};
    @Override
    public boolean add(T element) {
        if (size==elements.length) elements = Arrays.copyOf(elements, elements.length*3/2+1);
        if (size==0) elements[size++] = element;
        else {
            int end = size;
            int count = 0;
            for (int i = 0; i < end; i++) {
                if (elements[i].equals(element)) count++;
            }
            if (count==0) elements[size++] = element;
        }
        return false;
    }

    @Override
    public boolean remove(Object object) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter= ", ";
        }
        sb.append("]");
        return sb.toString();
    }
    //-----------------------------------------------------------------------------------------------------

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}
