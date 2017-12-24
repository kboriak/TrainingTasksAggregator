package ua.kharkiv.kboriak.hackerrank.algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/equal/problem
public class Equal {

    private static int getMinNumberOfOperations(int[] testCase) {
        int min = Arrays.stream(testCase).min().orElse(0);
        int[] operationsCount = new int[3];
        for (int i = 0; i <= 2; i++) {
            for (int aTestCase : testCase) {
                int diff = aTestCase - min + i;
                operationsCount[i] += diff / 5 + (diff % 5) / 2 + (diff % 5) % 2;
            }
        }
        return Math.min(Math.min(operationsCount[0], operationsCount[1]), operationsCount[2]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[\\n\\s]+");
        int t = scanner.nextInt();
        int[][] testCases = new int[t][];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] testCase = new int[n];
            for (int j = 0; j < n; j++) {
                testCase[j] = scanner.nextInt();
            }
            testCases[i] = testCase;
        }
        scanner.close();
        Arrays.stream(testCases).forEach(testCase -> System.out.println(getMinNumberOfOperations(testCase)));
    }
}
