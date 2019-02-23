package by.bsu.mmf.datastructure.tree;

public class AVLTreeTest {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.add(5);
        avlTree.add(3);
        avlTree.add(4);

        for (int i : avlTree.getValuesTreeOrder()) {
            System.out.println(i);
        }
        System.out.println("--------------");

    }

}
