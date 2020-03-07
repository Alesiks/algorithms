package by.bsu.mmf.algo.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MaxSubArraySumTest {
    private MaxSubArraySum maxSubArraySum = new MaxSubArraySum();

    @Test
    public void test1() {
        int actualSum = maxSubArraySum.get(new int[]{-1, -2, -3, -4, -5, -6});
        assertEquals(-1, actualSum);
    }

    @Test
    public void test2() {
        int actualSum = maxSubArraySum.get(new int[]{2, -1, 2, 3, 4, -5});
        assertEquals(10, actualSum);
    }

}
