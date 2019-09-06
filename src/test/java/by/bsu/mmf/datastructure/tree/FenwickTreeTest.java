package by.bsu.mmf.datastructure.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FenwickTreeTest {

    @Test
    public void sumTest() {
        int[] values = {1, 2, 1, 2, 4, 5, 7, -1, 9};
        FenwickTree fenwickTree = new FenwickTree(values.length);
        for (int i = 0; i < values.length; i++) {
            fenwickTree.update(i + 1, values[i]);
        }

        int[] expectedSumArray = new int[]{1,3,4,6,10,15,22,21,30};
        for (int i = 0; i < values.length; i++) {
            assertEquals(fenwickTree.sumRange(i + 1), expectedSumArray[i]);
        }
    }

}
