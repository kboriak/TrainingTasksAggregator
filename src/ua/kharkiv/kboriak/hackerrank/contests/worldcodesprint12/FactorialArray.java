package ua.kharkiv.kboriak.hackerrank.contests.worldcodesprint12;

import ua.kharkiv.kboriak.utils.annotations.Unsolved;

import java.util.Scanner;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/factorial-array
@Unsolved
public class FactorialArray {

    private static final int INCREMENT = 1;
    private static final int FACTORIAL_SUM = 2;
    private static final int SET = 3;

    private static final int MODULO = (int) Math.pow(10, 9);

    private static final int[] CACHE = new int[]{
            1,
            1,
            2,
            6,
            24,
            120,
            720,
            5040,
            40320,
            362880,
            3628800,
            39916800,
            479001600,
            227020800,
            178291200,
            674368000,
            789888000,
            428096000,
            705728000,
            408832000,
            176640000,
            709440000,
            607680000,
            976640000,
            439360000,
            984000000,
            584000000,
            768000000,
            504000000,
            616000000,
            480000000,
            880000000,
            160000000,
            280000000,
            520000000,
            200000000,
            200000000,
            400000000,
            200000000,
            800000000
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        int[] appliedOperations = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int[][] operations = new int[m][];
        for (int o = 0; o < m; o++) {
            int type = in.nextInt();
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            operations[o] = new int[]{type, l, r};
            if (type == FACTORIAL_SUM) {
                int sum = 0;
                for (int i = l; i <= r; i++) {
                    for (int j = appliedOperations[i]; j < o; j++) {
                        int[] operation = operations[j];
                        if (operation[0] == INCREMENT && i >= operation[1] && i <= operation[2]) {
                            A[i]++;
                        } else if (operation[0] == SET && i == operation[1]) {
                            A[i] = operation[2] + 1;
                        }
                        appliedOperations[i]++;
                    }
                    sum = (sum + (A[i] < 40 ? CACHE[A[i]] : 0)) % MODULO;
                }
                System.out.println(sum);
            }
        }
        in.close();
    }
}
