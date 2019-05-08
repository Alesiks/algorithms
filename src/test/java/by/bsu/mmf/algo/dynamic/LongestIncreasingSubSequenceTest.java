package by.bsu.mmf.algo.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LongestIncreasingSubSequenceTest {

    LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();

    @Test
    public void testGetSize1_simple() {
        int[] arr = {2, 4, 3, 7, 4, 5};
        int expectedRes = 4;

        int res = longestIncreasingSubsequence.getSize1(arr);
        assertEquals(expectedRes, res);
    }

    @Test
    public void testGetSize1_10000elements() throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("data_longest_increasing_subsequence.txt").toURI());

        Stream<String> lines = Files.lines(path);
        int[] arr = lines.mapToInt(Integer::valueOf).toArray();
        lines.close();
        int expectedRes = 195;

        int res = longestIncreasingSubsequence.getSize1(arr);
        assertEquals(expectedRes, res);
    }

    @Test
    public void testGetSize2_simple() {
        int[] arr = {1, 2, 3, 4, 5};
        int expectedRes = 5;

        int res = longestIncreasingSubsequence.getSize2(arr);
        assertEquals(expectedRes, res);
    }

    @Test
    public void testGetSize2_10000elements() throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("data_longest_increasing_subsequence.txt").toURI());

        Stream<String> lines = Files.lines(path);
        int[] arr = lines.mapToInt(Integer::valueOf).toArray();
        lines.close();
        int expectedRes = 195;

        int res = longestIncreasingSubsequence.getSize2(arr);
        assertEquals(expectedRes, res);
    }

}
