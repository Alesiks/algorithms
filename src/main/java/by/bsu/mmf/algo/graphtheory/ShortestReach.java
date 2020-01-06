package by.bsu.mmf.algo.graphtheory;

import java.util.*;

/**
 * task from HackerRank
 * Breadth first search is used to solve the problem
 * <p>
 * Consider an undirected graph where each edge is the same weight. Each of the nodes is labeled consecutively.
 * You will be given a number of queries. For each query, you will be given a list of edges describing an undirected graph.
 * After you create a representation of the graph, you must determine and report the shortest distance to each of the other nodes from a given starting position,
 * if a node is unreachable, print -1 for that node.
 */
public class ShortestReach {

    final static int EDGE_LENGTH = 6;

    private static int[] bfs(Map<Integer, Set<Integer>> graph, int startVertex) {
        int[] resDistances = new int[graph.size()];
        Arrays.fill(resDistances, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> marked = new HashSet<>();

        resDistances[adjustIndexForArrays(startVertex)] = 0;
        marked.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Integer currVertex = queue.poll();
            int currDistance = resDistances[adjustIndexForArrays(currVertex)];

            for (Integer adjacentVertex : graph.get(currVertex)) {
                if (!marked.contains(adjacentVertex)) {
                    resDistances[adjustIndexForArrays(adjacentVertex)] = currDistance + EDGE_LENGTH;
                    marked.add(adjacentVertex);
                    queue.add(adjacentVertex);
                }
            }
        }

        return resDistances;
    }

    private static int adjustIndexForArrays(int index) {
        return index - 1;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                graph.put(i, new HashSet<>());
            }

            for (int i = 0; i < m; i++) {
                int vertex_i = in.nextInt();
                int vertex_j = in.nextInt();
                graph.get(vertex_i).add(vertex_j);
                graph.get(vertex_j).add(vertex_i);
            }
            int startVertex = in.nextInt();
            int[] result = bfs(graph, startVertex);
            for (int i = 0; i < result.length; i++) {
                if(i != startVertex - 1) {
                    System.out.print(result[i] + (i != result.length - 1 ? " " : "\n"));
                }
            }
        }
        in.close();
    }

}