package by.bsu.mmf.datastructure.tree;

public class BinarySearchTreeValidator {

    public boolean isValidBST(TreeNode root) {
        return isValid(root.left, root.val, Long.MIN_VALUE) &&
                isValid(root.right, Long.MAX_VALUE, root.val);
    }

    private boolean isValid(TreeNode node, long lessThan, long greaterThan) {
        if (node != null) {
            if (node.val < lessThan && node.val > greaterThan) {
                return isValid(node.left, node.val, greaterThan) && isValid(node.right, lessThan, node.val);
            } else {
                return false;
            }
        }
        return true;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}