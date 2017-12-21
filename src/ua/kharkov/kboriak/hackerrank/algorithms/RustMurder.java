package ua.kharkov.kboriak.hackerrank.algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/rust-murderer/problem
public class RustMurder {

    private static class TestCase {
        private int cities;
        private Map<Integer, Set<Integer>> roads;
        private int startCity;

        TestCase(int cities) {
            this.cities = cities;
            this.roads = new HashMap<>();
        }
    }

    private static int[] calculateDistances(TestCase testCase) {
        int[] distances = new int[testCase.cities];
        Queue<Integer> edgeCities = new LinkedList<>();
        edgeCities.add(testCase.startCity);
        Set<Integer> unmarkedCities = Stream.iterate(1, n -> n + 1).limit(testCase.cities).collect(Collectors.toSet());
        unmarkedCities.remove(testCase.startCity);
        do {
            int currentCity = edgeCities.poll();
            int distance = distances[currentCity - 1];
            Set<Integer> citiesToBeMarked = new HashSet<>(unmarkedCities);
            Set<Integer> fromCurrentCity = testCase.roads.computeIfAbsent(currentCity, n -> new HashSet<>());
            citiesToBeMarked.removeAll(fromCurrentCity);
            citiesToBeMarked.forEach(city -> {
                distances[city - 1] = distance + 1;
                edgeCities.add(city);
            });
            unmarkedCities.retainAll(fromCurrentCity);
        } while (unmarkedCities.size() != 0);
        return distances;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[\\s+]");
        int t = scanner.nextInt();
        TestCase[] testCases = new TestCase[t];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            TestCase testCase = new RustMurder.TestCase(n);
            for (int j = 0; j < m; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Set<Integer> fromX = testCase.roads.computeIfAbsent(x, k -> new HashSet<>());
                fromX.add(y);
                Set<Integer> fromY = testCase.roads.computeIfAbsent(y, k -> new HashSet<>());
                fromY.add(x);
            }
            testCase.startCity = scanner.nextInt();
            testCases[i] = testCase;
        }
        scanner.close();
        for (TestCase testCase : testCases) {
            Arrays.stream(calculateDistances(testCase)).filter(d -> d != 0).forEach(d -> System.out.print(d + " "));
            System.out.println();
        }
    }
}