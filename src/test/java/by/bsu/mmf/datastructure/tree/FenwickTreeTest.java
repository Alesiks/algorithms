package by.bsu.mmf.datastructure.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FenwickTreeTest {

    @Test
    public void sumTest() {
        int[] values = {1, 2, 1, 2, 4, 5, 7, -1, 9};
        FenwickTree fenwickTree = new FenwickTree(values);
        int treeArr[] = fenwickTree.getTreeArr();
        for (int i = 0; i < treeArr.length; i++) {
            System.out.print(treeArr[i] + " ");
        }
    }

}
