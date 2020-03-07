package by.bsu.mmf.datastructure.set;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DisjointSet {

    private Map<Integer, Node> nodesMap = new HashMap<>();

    public void makeSet(int value) {
        Node node = new Node(value);
        nodesMap.put(value, node);
    }

    public void union(int a, int b) {
        Node representativeNodeForA = findRepresentativeNode(a);
        Node representativeNodeForB = findRepresentativeNode(b);

        if(representativeNodeForA.equals(representativeNodeForB)) {

        } else if(representativeNodeForA.getRank() > representativeNodeForB.getRank()) {
            representativeNodeForB.setParent(representativeNodeForA);
        } else if(representativeNodeForA.getRank() == representativeNodeForB.getRank()) {
            representativeNodeForB.setParent(representativeNodeForA);
            representativeNodeForA.incrementRank();
        } else if(representativeNodeForA.getRank() < representativeNodeForB.getRank()) {
            representativeNodeForA.setParent(representativeNodeForB);
        }
    }

    public Node findRepresentativeNode(int value) {
        Node representativeNode = nodesMap.get(value);
        while (representativeNode.getParent() != null) {
            representativeNode = representativeNode.getParent();
        }
        return representativeNode;
    }

}


class Node {

    private int value;

    private int rank;

    private Node parent;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRank() {
        return rank;
    }

    public void incrementRank() {
        rank++;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                rank == node.rank &&
                Objects.equals(parent, node.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, rank, parent);
    }
}