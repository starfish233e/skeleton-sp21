package deque;

import java.util.Iterator;
import java.util.LinkedList; // 或者 java.util.ArrayDeque
import java.util.ListIterator;

// 这个类只是一个包装器，实际使用Java内置的Deque
public class GoldenDeque<T> implements Deque<T> {
    private LinkedList<T> internalDeque; // 或者 ArrayDeque<T>

    public Iterator<T> iterator() {
        return new ListIterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };
    }


    public GoldenDeque() {
        internalDeque = new LinkedList<>();
    }

    @Override
    public void addFirst(T item) {
        internalDeque.addFirst(item);
    }

    @Override
    public void addLast(T item) {
        internalDeque.addLast(item);
    }

    @Override
    public boolean isEmpty() {
        return internalDeque.isEmpty();
    }

    @Override
    public int size() {
        return internalDeque.size();
    }

    @Override
    public void printDeque() {
        // 可以根据需要实现打印，或者在测试中不关注打印
        for (T item : internalDeque) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (internalDeque.isEmpty()) {
            return null;
        }
        return internalDeque.removeFirst();
    }

    @Override
    public T removeLast() {
        if (internalDeque.isEmpty()) {
            return null;
        }
        return internalDeque.removeLast();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= internalDeque.size()) {
            return null;
        }
        return internalDeque.get(index);
    }
}
