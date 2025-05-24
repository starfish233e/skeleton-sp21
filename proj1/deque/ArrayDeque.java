package deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Create an empty ArrayDeque. */
    public ArrayDeque() {
        items = (T[]) new Object[100];
        size = 0;
        nextFirst = 50;
        nextLast = 51;
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

    public int plusOne(int index) {
        return (index + 1) % items.length;
    }

    public int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /** Adds an item of type T to the front of the deque. You can assume that item is never null. */
    public void addFirst(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. You can assume that item is never null. */
    public void addLast(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == items.length;
    }

    /** Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line. */
    public void printDeque() {
        for (int i = 0; i < items.length; i += 1) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
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
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            int trueIndex = (nextFirst + 1 + index + items.length) % items.length;
            return items[trueIndex];
        }
    }
}
