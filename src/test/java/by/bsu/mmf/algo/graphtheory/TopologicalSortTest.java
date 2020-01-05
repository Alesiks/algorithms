package by.bsu.mmf.algo.graphtheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TopologicalSortTest {

    private TopologicalSort topologicalSort = new TopologicalSort();

    @Test
    public void topologicalSortTest1() {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.putIfAbsent(5, Stream.of(11).collect(toSet()));
        graph.putIfAbsent(11, Stream.of(2, 10, 9).collect(toSet()));
        graph.putIfAbsent(7, Stream.of(11, 8, 5).collect(toSet()));
        graph.putIfAbsent(8, Stream.of(9).collect(toSet()));
        graph.putIfAbsent(3, Stream.of(7, 8, 10).collect(toSet()));

        List<Integer> actualResult = topologicalSort.sort(graph);
        List<Integer> expectedResult = asList(3, 7, 5, 11, 2, 8, 9, 10);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void topologicalSortTest2() {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.putIfAbsent(1, Stream.of(2, 4).collect(toSet()));
        graph.putIfAbsent(2, Stream.of(3).collect(toSet()));
        graph.putIfAbsent(4, Stream.of(5).collect(toSet()));
        graph.putIfAbsent(3, Stream.of(5).collect(toSet()));

        List<Integer> actualResult = topologicalSort.sort(graph);
        List<Integer> expectedResult = asList(1, 2, 3, 4, 5);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void topologicalSortTest3() {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.putIfAbsent(1, Stream.of(2, 4).collect(toSet()));
        graph.putIfAbsent(2, Stream.of(3, 6).collect(toSet()));
        graph.putIfAbsent(4, Stream.of(5).collect(toSet()));
        graph.putIfAbsent(3, Stream.of(5).collect(toSet()));
        graph.putIfAbsent(6, Stream.of(3, 7).collect(toSet()));
        graph.putIfAbsent(7, Stream.of(3, 4).collect(toSet()));


        List<Integer> actualResult = topologicalSort.sort(graph);
        List<Integer> expectedResult = asList(1, 2, 6, 7, 3, 4, 5);
        assertEquals(expectedResult, actualResult);
    }

}
