package by.bsu.mmf.algo.algebra.factorization;

import java.util.Random;

public class Factorizer {

    // test implementation
    // method returns prime divisor
    public static int factorizeRhoPollardAlgorithm(int num) {
        if (num == 1) {
            return 1;
        }

        if (num % 2 == 0) {
            return 2;
        }

        Random rand = new Random();

        int x = 7;
        int c = 23;
        int d = 1;

        while (d == 1) {
            x = f(x, c, num);
            int y = f(x, c, num);

            d = gcd(Math.abs(x - y), num);

            if(d == num) {
                return factorizeRhoPollardAlgorithm(d);
            }

        }
        return d;
    }

    private static int f(int x, int c, int module) {
        return (int) (((long)x * (long)x + (long)c) % module);
    }


    private static int gcd(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(factorizeRhoPollardAlgorithm(1827137));
    }


}
