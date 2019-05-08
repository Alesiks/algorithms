package by.bsu.mmf.algo.algebra;

public class GreatestCommonDivisor {

    public int get(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        return gcdRecursion(a, b);
    }

    // here a is greater than b
    private int gcdRecursion(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcdRecursion(b, a % b);
    }

}
