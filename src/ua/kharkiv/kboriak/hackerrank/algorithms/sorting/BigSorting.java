package ua.kharkiv.kboriak.hackerrank.algorithms.sorting;

import java.util.*;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/big-sorting/problem
public class BigSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> numbers = new ArrayList<>(n);
        IntStream.range(0, n).forEach(i -> numbers.add(scanner.next()));
        scanner.close();
        numbers.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(a -> a))
                .forEach(System.out::println);
    }
}
