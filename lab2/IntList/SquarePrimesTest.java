package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public  void testSquarePrimes0() {
        IntList lst = IntList.of(24, 23, 21, 31, 71, 8);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("24 -> 529 -> 21 -> 961 -> 5041 -> 8", lst.toString());
        assertTrue(changed);
    }

    @Test
    public  void testSquarePrimes1() {
        IntList lst = IntList.of(14, 33, 41, 30, 7, 81);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 33 -> 1681 -> 30 -> 49 -> 81", lst.toString());
        assertTrue(changed);
    }

    @Test
    public  void testSquarePrimes2() {
        IntList lst = IntList.of(4, 3, 67, 10, 7, 8);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 4489 -> 10 -> 49 -> 8", lst.toString());
        assertTrue(changed);
    }
}
