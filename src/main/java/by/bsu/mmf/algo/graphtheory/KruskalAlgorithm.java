package by.bsu.mmf.algo.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * todo implement it
 * MST - Minimum spanning tree
 */
public class KruskalAlgorithm {

    public static int minimumSpanningTreeWeightsSum(List<Edge> edgeList, Map<Integer, Set<Edge>> graph) {
        return minimumSpanningTree(edgeList, graph).stream().mapToInt(Edge::getWeight).sum();
    }

    public static List<Edge> minimumSpanningTree(List<Edge> edgeList, Map<Integer, Set<Edge>> graph) {
        Collections.sort(edgeList);
        final int MSTSize = graph.size() - 1;

        List<Edge> MSTEdges = new ArrayList<>();
        for (Edge edge : edgeList) {
//            if (!doesEdgeAddsLoopToTree(graph, MSTEdges, edge)) {
//                MSTEdges.add(edge);
//                if (isTreeMST(MSTSize, MSTEdges.size())) {
//                    break;
//                }
//            }
        }
        return MSTEdges;
    }

//    private static boolean doesEdgeAddsLoopToTree(Map<Integer, Set<Edge>> graph, List<Edge> currMSTTree, Edge possibleTreeEdge) {
//
//    }

    private static boolean isTreeMST(final int MSTSize, final int edgesInMST) {
        return MSTSize == edgesInMST;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);
        Map<Integer, Set<Edge>> graph = new HashMap<>();
        List<Edge> edgeList = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                Edge edge = new Edge(
                        Integer.parseInt(gFromToWeight[0]),
                        Integer.parseInt(gFromToWeight[1]),
                        Integer.parseInt(gFromToWeight[2])
                );
                graph.computeIfAbsent(edge.getFrom(), from -> new HashSet<>()).add(edge);
                graph.computeIfAbsent(edge.getTo(), to -> new HashSet<>()).add(edge);
                edgeList.add(edge);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

//        int res = KruskalAlgorithm.minimumSpanningTree(edgeList, graph);

        // Write your code here.

        bufferedReader.close();
    }

}

class Edge implements Comparable<Edge> {
    private int from;
    private int to;
    private int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }


    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(weight, edge.weight);
    }
}
