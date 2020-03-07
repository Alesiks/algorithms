package by.bsu.mmf.algo.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class LongestCommonSubsequenceTest {

    LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

    @Test
    public void test1() {

        int[] res = longestCommonSubsequence.get(new int[]{1, 2, 3, 4, 1}, new int[]{3, 4, 1, 2, 1, 3});
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test2() {

        int[] res = longestCommonSubsequence.get(new int[]{3, 9, 8, 3, 9, 7, 9, 7, 0}, new int[]{3, 3, 9, 9, 9, 1, 7, 2, 0, 6});
        System.out.println(Arrays.toString(res));
    }


}
