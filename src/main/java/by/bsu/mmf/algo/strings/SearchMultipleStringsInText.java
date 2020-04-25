package by.bsu.mmf.algo.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Used Aho-Corasick algorithm to find all patterns occurrences in some text. Complexity is O(len(text) + len(ans))
 * ans - the length of answer
 */
class SearchMultipleStringsInText {

    private AhoCorasickAlgorithm algo = new AhoCorasickAlgorithm();

    public Map<String, Integer> findOccurrences(List<String> patterns, String text) {
        Map<String, Integer> result = new HashMap<>();

        patterns.forEach(pattern -> {
            algo.addPattern(pattern);
            result.putIfAbsent(pattern, 0);
        });

        Node curr = algo.getRoot();
        for (char ch : text.toCharArray()) {
            curr = algo.go(curr, ch);
            if (curr.leaf) {
                String matchingStr = curr.matchingString;
                result.compute(matchingStr, (k, v) -> v == null ? 1 : v + 1);
            }
            Node suffixLinkedLeafNode = algo.getNearestSuffixLinkedLeaf(curr);
            while (!algo.getRoot().equals(suffixLinkedLeafNode)) {
                String matchingStr = suffixLinkedLeafNode.matchingString;
                result.compute(matchingStr, (k, v) -> v == null ? 1 : v + 1);
                suffixLinkedLeafNode = algo.getNearestSuffixLinkedLeaf(suffixLinkedLeafNode);
            }
        }
        return result;
    }

}


class AhoCorasickAlgorithm {

    private Node root;

    public AhoCorasickAlgorithm() {
        root = new Node();
        root.suffixLink = root;
    }

    public Node getRoot() {
        return root;
    }

    public void addPattern(String pattern) {
        Node curr = root;
        for (char ch : pattern.toCharArray()) {
            if (curr.next.get(ch) == null) {
                Node newNode = new Node(curr, ch);
                curr.next.put(ch, newNode);
            }
            curr = curr.next.get(ch);
        }
        curr.leaf = true;
        curr.matchingString = pattern;
    }

    public Node go(Node curr, char ch) {
        if (curr.go.get(ch) == null) {
            if (curr.next.get(ch) != null) {
                curr.go.put(ch, curr.next.get(ch));
            } else {
                Node next = root.equals(curr) ? root : go(getLink(curr), ch);
                curr.go.put(ch, next);
            }

        }
        return curr.go.get(ch);
    }

    public Node getLink(Node curr) {
        if (curr.suffixLink == null) {
            if (root.equals(curr) || root.equals(curr.parent)) {
                curr.suffixLink = root;
            } else {
                curr.suffixLink = go(getLink(curr.parent), curr.parentConnectingChar);
            }
        }
        return curr.suffixLink;
    }

    public Node getNearestSuffixLinkedLeaf(Node curr) {
        if(curr.nearestSuffixLinkedLeaf == null) {
            if(root.equals(curr) || root.equals(curr.parent)) {
                curr.nearestSuffixLinkedLeaf = root;
            } else {
                Node node = getLink(curr);
                if(node.leaf) {
                    curr.nearestSuffixLinkedLeaf = node;
                } else {
                    curr.nearestSuffixLinkedLeaf = getNearestSuffixLinkedLeaf(node);
                }
            }
        }
        return curr.nearestSuffixLinkedLeaf;
    }

}


class Node {
    public Node() {
    }

    public Node(Node parent, char parentConnectingChar) {
        this.parent = parent;
        this.parentConnectingChar = parentConnectingChar;
    }

    Map<Character, Node> next = new HashMap<>();
    Map<Character, Node> go = new HashMap<>();

    boolean leaf;
    String matchingString;
    Node nearestSuffixLinkedLeaf;

    Node parent;
    char parentConnectingChar;

    Node suffixLink;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return leaf == node.leaf &&
                parentConnectingChar == node.parentConnectingChar &&
                Objects.equals(next, node.next) &&
                Objects.equals(go, node.go) &&
                Objects.equals(matchingString, node.matchingString) &&
                Objects.equals(parent, node.parent) &&
                Objects.equals(suffixLink, node.suffixLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, go, leaf, matchingString, parent, parentConnectingChar, suffixLink);
    }
}