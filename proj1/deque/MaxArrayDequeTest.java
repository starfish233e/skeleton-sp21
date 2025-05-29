package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void testNatural() {
        MaxArrayDeque<Integer> m = new MaxArrayDeque<Integer>(Comparator.naturalOrder());
        for (int i = 0; i < 100; i += 1) {
            m.addFirst(i);
        }
        assertEquals(m.max(), Integer.valueOf(99));
    }

    @Test
    public void testString() {
        MaxArrayDeque<String> names = new MaxArrayDeque<String>(Comparator.naturalOrder());
        names.addLast("Charlie");
        names.addLast("Alice");
        names.addFirst("Bob");
        names.addFirst("David");
        assertEquals("David", names.max());
    }
}
