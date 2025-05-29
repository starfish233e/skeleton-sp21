package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> defaultComparator;
    /** Creates a MaxArrayDeque with the given Comparator. */
    public MaxArrayDeque(Comparator<T> c) {
        super();
        defaultComparator = c;
    }

    /** Returns the maximum element in the deque as governed by the previously given Comparator. If the MaxArrayDeque is empty, simply return null. */
    public T max() {
        if (isEmpty()) {
            return null;
        } else {
            T maxOne = get(0);
            for (int i = 1; i < size(); i += 1) {
                T currentItem = get(i);
                if (defaultComparator.compare(currentItem, maxOne) > 0) {
                    maxOne = currentItem;
                }
            }
            return maxOne;
        }
    }

    /** Returns the maximum element in the deque as governed by the parameter Comparator c. If the MaxArrayDeque is empty, simply return null. */
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        } else {
            T maxOne = get(0);
            for (int i = 1; i < size(); i += 1) {
                T currentItem = get(i);
                if (c.compare(currentItem, maxOne) > 0) {
                    maxOne = currentItem;
                }
            }
            return maxOne;
        }
    }
}
