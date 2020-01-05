package by.bsu.mmf.algo.strings;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KMPAlgorithmTest {

    private KMPAlgorithm kmpAlgorithm = new KMPAlgorithm();

    @Test
    public void prefixFunctionTest1() {
        String s = "aabaaab";
        int[] actualPrefixFunction = kmpAlgorithm.calculatePrefixFunction(s);
        int[] expectedPrefixFunction = new int[]{0,1,0,1,2,2,3};
        Assert.assertArrayEquals(expectedPrefixFunction, actualPrefixFunction);
    }

    @Test
    public void prefixFunctionTest2() {
        String s = "aabaabaaa";
        int[] actualPrefixFunction = kmpAlgorithm.calculatePrefixFunction(s);
        int[] expectedPrefixFunction = new int[]{0,1,0,1,2,3,4,5,2};
        Assert.assertArrayEquals(expectedPrefixFunction, actualPrefixFunction);
    }


}
