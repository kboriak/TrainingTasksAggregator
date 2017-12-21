package ua.kharkov.kboriak.hackerrank.algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/big-sorting/problem
public class BigSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        Map<String, Integer> uniqueNumbers = new HashMap<>();
        IntStream.range(0, n).forEach(i -> uniqueNumbers.merge(scanner.nextLine(), 1, (a, b) -> a + b));
        scanner.close();
        StringBuilder sb = new StringBuilder();
        uniqueNumbers.keySet().stream().sorted(Comparator.comparingInt(String::length).thenComparing(a -> a))
                .forEach(key -> IntStream.range(0, uniqueNumbers.get(key)).forEach(i -> sb.append(key).append('\n')));
        System.out.println(sb);
    }
}
