package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> goodList = new AListNoResizing<>();
        BuggyAList<Integer> badList = new BuggyAList<>();
        int[] testNum = new int[]{4, 5, 6};
        for (int k : testNum) {
            goodList.addLast(k);
            badList.addLast(k);
        }
        int size = goodList.size();
        for (int i = 0; i < size; i += 1) {
            int a = goodList.removeLast();
            int b = badList.removeLast();
            assertEquals(a, b);
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                assertEquals(size1, size2);
                System.out.println("size: " + size1);
            } else if (L.size() > 0) {
                if (operationNumber == 2) {
                    int a = L.getLast();
                    int b = B.getLast();
                    assertEquals(a, b);
                    System.out.println("get AList last:" + a);
                    System.out.println("get BList last:" + a);
                } else if (operationNumber == 3) {
                    int a = L.removeLast();
                    int b = B.removeLast();
                    assertEquals(a, b);
                    System.out.println("remove AList last:" + a);
                    System.out.println("remove BList last:" + b);
                }
            }
        }
    }
}
