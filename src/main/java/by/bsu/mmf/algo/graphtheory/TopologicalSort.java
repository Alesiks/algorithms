package by.bsu.mmf.algo.graphtheory;

import java.util.*;
import java.util.stream.IntStream;

public class TopologicalSort {

    // returns one of possible topological sorting for a graph
    public List<Integer> sort(Map<Integer, Set<Integer>> graph) {
        Deque<Integer> sortedVertexes = new LinkedList<>();
        Set<Integer> usedInSortingVertexes = new HashSet<>();
        Set<Integer> usedVertexes = new HashSet<>();
        Deque<Integer> dfsStack = new LinkedList<>();

        List<Integer> vertexes = new ArrayList<>(graph.keySet());
        for (int i = 0; i < vertexes.size(); i++) {
            Integer startVertex = vertexes.get(i);
            if(usedVertexes.contains(startVertex)) {
                continue;
            }
            dfsStack.push(startVertex);
            while (!dfsStack.isEmpty()) {
                Integer vertex = dfsStack.getFirst();
                if(usedVertexes.contains(vertex)) {
                    dfsStack.pop();
                    if(!usedInSortingVertexes.contains(vertex)) {
                        sortedVertexes.push(vertex);
                        usedInSortingVertexes.add(vertex);
                    }
                } else {
                    usedVertexes.add(vertex);
                    Set<Integer> adjacentVertexes = graph.get(vertex);
                    if (adjacentVertexes != null && !adjacentVertexes.isEmpty()) {
                        adjacentVertexes.stream().filter(v -> !usedVertexes.contains(v)).forEach(dfsStack::push);
                    }
                }
            }
        }

        List<Integer> topologicalSorting = new ArrayList<>();
        IntStream.range(0, sortedVertexes.size()).forEachOrdered(i -> topologicalSorting.add(sortedVertexes.removeFirst()));
        return topologicalSorting;
    }


}
