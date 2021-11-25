package by.bsu.mmf.algo.algebra;

public class LeastCommonMultiple {

    private final GreatestCommonDivisor gcd = new GreatestCommonDivisor();

    public int get(int a, int b) {

        return (a * b) / gcd.get(a, b);
    }

}
