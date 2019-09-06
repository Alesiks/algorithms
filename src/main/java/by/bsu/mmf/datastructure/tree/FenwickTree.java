package by.bsu.mmf.datastructure.tree;

// allows to calculate the value of some reversible operation F on any segment [L; R] in logarithmic time;
// allows you to change the value of any element in O(logn)
// implementation for calculating sum on interval
class FenwickTree {

    private long[] arr;

    public FenwickTree(int size) {
        this.arr = new long[size + 1];
    }

    public void update(int i, int delta) {
        while (i < arr.length) {
            arr[i] += delta;
            i += getLeastSignificantNonZeroBit(i);
        }
    }

    public long sumRange(int range) {
        long sum = 0;
        while (range > 0) {
            sum += arr[range];
            range -= getLeastSignificantNonZeroBit(range);
        }
        return sum;
    }

    public long sumInterval(int a, int b) {
        return sumRange(b) - sumRange(a - 1);
    }

    private int getLeastSignificantNonZeroBit(int num) {
        return num & -num;
    }

}

