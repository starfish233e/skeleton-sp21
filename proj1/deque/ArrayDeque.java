package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int currentPos;
        public ArrayDequeIterator() {
            currentPos = 0;
        }
        public boolean hasNext() {
            return currentPos < size;
        }

        public T next() {
            T returnItem = items[currentPos];
            currentPos += 1;
            return returnItem;
        }
    }

    /** Create an empty ArrayDeque. */
    public ArrayDeque() {
        items = (T[]) new Object[100];
        size = 0;
        nextFirst = 50;
        nextLast = 51;
    }

    public ArrayDeque(int capacity) {
        items = (T[]) new Object[capacity];
        size = 0;
        nextFirst = capacity / 2;
        nextLast = plusOne(nextFirst);
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);

        for (int i = 0; i < size; i += 1) {
            a[i] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }

        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /** Adds an item of type T to the front of the deque. You can assume that item is never null. */
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. You can assume that item is never null. */
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /** Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == items.length;
    }

    /** Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line. */
    @Override
    public void printDeque() {
        for (int i = 0; i < items.length; i += 1) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            nextFirst = plusOne(nextFirst);
            T temp = items[nextFirst];
            items[nextFirst] = null;
            size -= 1;
            return temp;
        }
    }

    /**  Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            nextLast = minusOne(nextLast);
            T temp = items[nextLast];
            items[nextLast] = null;
            size -= 1;
            return temp;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque! */
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            int trueIndex = (nextFirst + 1 + index + items.length) % items.length;
            return items[trueIndex];
        }
    }
}
