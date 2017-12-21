package ua.kharkov.kboriak.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/equal/problem
// NOT SOLVED
public class Equal {

    private static int method(int[] testCase) {
        Arrays.sort(testCase);
        int count = 0;
        int diff = 0;
        for (int i = 1; i < testCase.length; i++) {
            diff = testCase[i] - testCase[i - 1];
            int fives = diff / 5;
            count += fives;
            if (diff % 5 == 3 && (i < testCase.length - 1) && (testCase[i] == testCase[i + 1])) {
                diff += 12 + fives * 5;
                count += 3 + fives;
                i++;
            } else if (diff % 5 == 4 && (i < testCase.length - 1) && (testCase[i] == testCase[i + 1])) {
                diff += 11 + fives * 5;
                count += 3 + fives;
                i++;
            } else {
                count += (diff % 5) / 2 + (diff % 5) % 2;
            }
        }
        return count;
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
        Arrays.stream(testCases).forEach(testCase -> System.out.println(method(testCase)));
    }
}
