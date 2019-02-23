package by.bsu.mmf.datastructure.tree;

// allows to calculate the value of some reversible operation F on any segment [L; R] in logarithmic time;
// allows you to change the value of any element in O(nlogn)
// implementation for calculating sum on interval
public class FenwickTree {

    private int treeArr[];

    public FenwickTree(int[] values) {
        treeArr = new int[values.length + 1];
        for(int i = 0; i < values.length; i++) {
            update(i + 1, values[i]);
        }

    }

    public int sum(int range) {
        int i = range;
        int res = 0;
        while (i >= 0) {
            res += treeArr[i];
            i -= (i & -i);
        }
        return res;
    }

    public void update(int i, int delta) {
        while (i < treeArr.length) {
            treeArr[i] += delta;
            i += (i & -i);
        }
    }

    public int[] getTreeArr() {
        return treeArr;
    }
}
