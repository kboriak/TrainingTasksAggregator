package ua.kharkiv.kboriak.hackerrank.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/mars-exploration/problem
public class MarsExploration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] signalLetters = scanner.next().toCharArray();
        scanner.close();
        int counter = 0;
        for (int i = 0; i < signalLetters.length; i+=3) {
            counter += signalLetters[i] != 'S' ? 1 : 0;
            counter += signalLetters[i + 1] != 'O' ? 1 : 0;
            counter += signalLetters[i + 2] != 'S' ? 1 : 0;
        }
        System.out.println(counter);
    }

}
