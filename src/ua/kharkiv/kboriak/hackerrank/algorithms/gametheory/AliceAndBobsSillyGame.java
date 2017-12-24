package ua.kharkiv.kboriak.hackerrank.algorithms.gametheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/alice-and-bobs-silly-game/problem
public class AliceAndBobsSillyGame {

    private static List<Integer> primesCache = new ArrayList<>();

    static {
        primesCache.add(2);
    }

    private static int countPrimes(int n) {
        int maxPrimeCached = primesCache.get(primesCache.size() - 1);
        if (maxPrimeCached >= n) {
            for (int i = 0; i < primesCache.size(); i++) {
                if (primesCache.get(i) == n) {
                    return i + 1;
                }
                if (primesCache.get(i) > n) {
                    return i;
                }
            }
        }
        int count = primesCache.size();
        outer:
        for (int i = maxPrimeCached + 1; i <= n; i++) {
            double upperBound = Math.sqrt(i);
            for (int j = 2; j <= upperBound; j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            count++;
            primesCache.add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            System.out.println(countPrimes(n) % 2 == 1 ? "Alice" : "Bob");
        }
        in.close();
    }
}
