package deque;

public class LinkedListDeque<T> implements Deque<T>{
    private class DequeNode {
        public T item;
        public DequeNode prev;
        public DequeNode next;

        public DequeNode(T i, DequeNode p, DequeNode r) {
            item = i;
            prev = p;
            next = r;
        }
    }

    /** The first item (if it exists) is at sentinel.next. */
    private DequeNode sentinel;
    private int size;

    /** Creates an empty LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque. You can assume that item is never null. */
    public void addFirst(T item) {
        DequeNode temp = sentinel.next;
        sentinel.next = new DequeNode(item, sentinel, temp);
        temp.prev = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. You can assume that item is never null. */
    public void addLast(T item) {
        DequeNode temp = sentinel.prev;
        sentinel.prev = new DequeNode(item, temp, sentinel);
        temp.next = sentinel.prev;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /** Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line. */
    public void printDeque() {
        DequeNode p = sentinel;

        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }

        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        DequeNode temp = sentinel.next;
        if (temp == sentinel) {
            return null;
        } else {
            temp.next.prev = sentinel;
            sentinel.next = temp.next;
            size -= 1;
            return temp.item;
        }
    }

    /**  Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        DequeNode temp = sentinel.prev;
        if (temp == sentinel) {
            return null;
        } else {
            temp.prev.next = sentinel;
            sentinel.prev = temp.prev;
            size -= 1;
            return temp.item;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            DequeNode p = sentinel;
            for (int i = 0; i < index; i += 1) {
                p = p.next;
            }
            return p.next.item;
        }
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        DequeNode p = sentinel;
        if (index >= size) {
            return null;
        } else {
            return getRecursiveHelper(p, index);
        }
    }

    /** Help to implete the getRecursive method. */
    public T getRecursiveHelper(DequeNode p, int index) {
        if (index == 0) {
            return p.next.item;
        } else {
            return getRecursiveHelper(p.next, index - 1);
        }
    }
}
