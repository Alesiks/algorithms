package by.bsu.mmf.datastructure.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class IsTreeBinaryTest {


    //                 10
    //          7              12
    //      5       9      11       18
    //  2                                20
    @Test
    public void treeIsBinaryTest() {
        TreeNode root = new TreeNode(10,
                new TreeNode(7,
                        new TreeNode(5, new TreeNode(2), null), new TreeNode(9)
                ),
                new TreeNode(12,
                        new TreeNode(11), new TreeNode(18, null, new TreeNode(20))));
        IsTreeBinary isTreeBinary = new IsTreeBinary();
        assertTrue(isTreeBinary.isValidBST(root));
    }

    //                 5
    //          1              6
    //      0              4       8
    @Test
    public void treeIsNotBinaryTest() {
        TreeNode root = new TreeNode(5,
                new TreeNode(1, new TreeNode(0), null),
                new TreeNode(6, new TreeNode(4), new TreeNode(8))
        );
        IsTreeBinary isTreeBinary = new IsTreeBinary();
        assertFalse(isTreeBinary.isValidBST(root));
    }

}
