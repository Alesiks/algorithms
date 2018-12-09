package by.bsu.mmf.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(int value) {
        if(root == null) {
            root = new Node(value);
        } else {
            add(root, value);
        }
    }

    private Node add(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else {
            if (value < node.getData()) {
                Node left = add(node.getLeft(), value);
                node.setLeft(left);
            } else {
                Node right = add(node.getRight(), value);
                node.setRight(right);
            }
        }
        updateHeight(node);
        return balance(node);
    }

    public void delete(int value) {

    }

    public int find(int value) {
        return find(root, value).getData();
    }

    private Node find(Node node, int value) {
        Node result = null;

        if (node != null) {
            if (value < node.getData()) {
                result = find(node.getLeft(), value);
            } else if (value == node.getData()) {
                result = node;
            } else {
                result = find(node.getRight(), value);
            }
        }

        return result;
    }

    public List<Integer> getValuesTreeOrder() {
        List<Integer> result = new ArrayList<>();
        Queue<Node> nodes = new LinkedList<>();

        if(root != null) {
            nodes.add(root);

            while (!nodes.isEmpty()) {
                Node curr = nodes.poll();
                result.add(curr.getData());
                if(curr.getLeft() != null) {
                    nodes.add(curr.getLeft());
                }

                if(curr.getRight() != null) {
                    nodes.add(curr.getRight());
                }
            }
        }
        return result;
    }

    private Node balance(Node node) {
        if (balanceFactor(node) < -1) {
            if (getHeight(node.getLeft().getRight()) > getHeight(node.getLeft().getLeft())) {
                Node left = leftRotate(node.getLeft());
                node.setLeft(left);
            }
            node = rightRotate(node);
        } else if (balanceFactor(node) > 1) {
            if (getHeight(node.getRight().getLeft()) > getHeight(node.getRight().getRight())) {
                Node right = rightRotate(node.getRight());
                node.setRight(right);
            }
            node = leftRotate(node);
        }
        return node;

    }

    private Node leftRotate(Node node) {
        Node newRootNode = node.getRight();

        Node leftSunOfNewRoot = newRootNode.getLeft();

        newRootNode.setLeft(node);
        node.setRight(leftSunOfNewRoot);

        updateHeight(node);
        updateHeight(newRootNode);

        if(node.getData() == root.getData()) {
            root = newRootNode;
        }

        return newRootNode;
    }

    private Node rightRotate(Node node) {
        Node newRootNode = node.getLeft();

        Node rightSunOfNewRoot = newRootNode.getRight();

        newRootNode.setRight(node);
        node.setLeft(rightSunOfNewRoot);

        updateHeight(node);
        updateHeight(newRootNode);

        if(node.getData() == root.getData()) {
            root = newRootNode;
        }

        return newRootNode;
    }

    private int balanceFactor(Node node) {
        int leftHeight = getHeight(node.getLeft());

        int rightHeight = getHeight(node.getRight());

        return rightHeight - leftHeight;
    }

    private void updateHeight(Node node) {
        int leftHeight = getHeight(node.getLeft());

        int rightHeight = getHeight(node.getRight());

        int height = Math.max(leftHeight, rightHeight) + 1;
        node.setHeight(height);

    }

    private int getHeight(Node node) {
        return node != null ? node.getHeight() : 0;
    }

}


class Node {

    private int data;

    private Node left;

    private Node right;

    private int height;

    public Node(int data) {
        this.data = data;
        this.height = 1;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void incrementHeight() {
        this.height++;
    }

    public void decrementHeight() {
        this.height--;
    }

}

