package ua.kharkiv.kboriak.hackerrank.contests.projecteuler.project196;

import ua.kharkiv.kboriak.utils.annotations.Unsolved;

import java.util.*;
import java.util.stream.IntStream;

@Unsolved
public class PrimeTriplets {

    private static final long[] ROW_CACHE = new long[]{0, 5, 5, 7};

    private static boolean[] sieve;
    private static long min;
    private static long max;

    private static void initializeSieve() {
        int maxDivisor = (int) Math.sqrt(max);
        sieve = new boolean[(int) (max - min + 1)];
        IntStream.range(0, sieve.length).forEach(i -> sieve[i] = true);
        IntStream.rangeClosed(2, maxDivisor).forEach(i -> setToFalse((int) ((i - min % i) % i), i));
    }

    private static void setToFalse(int startIndex, int step) {
        for (int i = startIndex; i < sieve.length; i += step) {
            sieve[i] = false;
        }
    }

    private static boolean isPrime(long x) {
        return sieve[(int) (x - min)];
    }

    private static long primeTripletsSum(int a) {
        if (a < 5) {
            return ROW_CACHE[a - 1];
        }
        long n0 = a * (a - 1) / 2 + 1;
        min = n0 - 2 * a + 3;
        max = n0 + 3 * a + 2;
        initializeSieve();
        long start = (n0 % 2 != 0 ? n0 : n0 + 1);
        long sum = 0;
        for (long i = start; i < n0 + a; i += 2) {
            if (isMemberOfPrimeTriplet(i, a, n0)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isMemberOfPrimeTriplet(long x, int a, long n0) {
        if (!isPrime(x)) {
            return false;
        }
        int primesAround = 0;
        if (a % 2 == 0) {
            if (x > n0 && isPrime(x - a)) {
                primesAround++;
                if (isPrime(x - 2 * a + 2)) {
                    return true;
                }
                if (x > n0 + 1 && isPrime(x - 2)) {
                    return true;
                }
            }
            if (x < n0 + a - 2 && isPrime(x - a + 2)) {
                primesAround++;
                if (primesAround >= 2) {
                    return true;
                }
                if (isPrime(x + 2)) {
                    return true;
                }
                if (x < n0 + a - 3 && isPrime(x - 2 * a + 4)) {
                    return true;
                }
            }
            if (isPrime(x + a)) {
                primesAround++;
                if (primesAround >= 2) {
                    return true;
                }
                if (isPrime(x + 2 * a)) {
                    return true;
                }
                if (isPrime(x + 2 * a + 2)) {
                    return true;
                }
            }
        } else {
            if (x < n0 + a - 1 && isPrime(x - a + 1)) {
                primesAround++;
                if (x > n0 && isPrime(x - 2 * a + 2)) {
                    return true;
                }
                if (x < n0 + a - 3 && isPrime(x - 2 * a + 4)) {
                    return true;
                }
            }
            if (isPrime(x + a + 1)) {
                primesAround++;
                if (primesAround >= 2) {
                    return true;
                }
                if (x < n0 + a - 2 && isPrime(x + 2)) {
                    return true;
                }
                if (isPrime(x + 2 * a + 2)) {
                    return true;
                }
            }
            if (x > n0 && isPrime(x + a - 1)) {
                primesAround++;
                if (primesAround >= 2) {
                    return true;
                }
                if (isPrime(x + 2 * a)) {
                    return true;
                }
                if (x > n0 + 1 && isPrime(x - 2)) {
                    return true;
                }
            }
        }
        return primesAround >= 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        System.out.println(primeTripletsSum(a) + primeTripletsSum(b));
    }
}
