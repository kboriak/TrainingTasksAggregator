package ua.kharkov.kboriak.hackerrank.contests.worldcodesprint12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/breaking-sticks
public class BreakingSticks {

    private static Map<Long, Long> cache = new HashMap<>();

    private static long longestSequence(long[] a) {
        long steps = 0;
        for (long number : a) {
            if (cache.containsKey(number)) {
                steps += cache.get(number);
                continue;
            }
            long original = number;
            long currentSteps = number;
            while (number > 1) {
                long minPlainDivisor = number;
                for (long i = 2; i <= (long) Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        minPlainDivisor = i;
                        break;
                    }
                }
                number /= minPlainDivisor;
                currentSteps += number;
            }
            cache.put(original, currentSteps);
            steps += currentSteps;
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }
}
