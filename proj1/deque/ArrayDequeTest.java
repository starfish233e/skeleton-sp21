package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;

public class ArrayDequeTest {
    @Test
    public void testOneHundredAddOneHundredRemove() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 100; i += 1) {
            deque.addFirst(i);
        }
        for (int i = 99; i >= 0; i -= 1) {
            int a = deque.removeFirst();
            assertEquals(i, a);
        }
    }

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertEquals(deque.isEmpty(), true);
        deque.addFirst(1);
        for (int i = 0; i < 200; i += 1) {
            deque.addLast(i);
            assertEquals(deque.isEmpty(), false);
        }

    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        GoldenDeque<Integer> golden = new GoldenDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                deque.addLast(randVal);
                golden.addLast(randVal);
            } else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 100);
                deque.addFirst(randVal);
                golden.addFirst(randVal);
            } else if (operationNumber == 2) {
                assertEquals(deque.removeLast(), golden.removeLast());
            } else if (operationNumber == 3) {
                assertEquals(deque.removeFirst(), golden.removeFirst());
            } else if (operationNumber == 4) {
                int randVal = StdRandom.uniform(0, 100);
                assertEquals(deque.get(randVal), golden.get(randVal));
            }
        }
    }
}
