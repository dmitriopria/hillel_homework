package hw20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeList<T> {
    private final List<T> list;

    public <T> ThreadSafeList() {
        list = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void add(T ellement) {
        list.add(ellement);
    }

    public synchronized void remove(T element) {
        list.remove(element);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }
}
