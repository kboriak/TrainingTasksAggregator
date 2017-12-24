package ua.kharkiv.kboriak.hackerrank.algorithms.implementation;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/migratory-birds/problem
public class MigratoryBirds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] birds = new int[5];
        for (int i = 0; i < n; i++) {
            birds[in.nextInt() - 1]++;
        }
        int max = birds[0];
        int indexOfMax = 0;
        for (int i = 1; i < 5; i++) {
            if (birds[i] > max) {
                max = birds[i];
                indexOfMax = i;
            }
        }
        System.out.println(indexOfMax + 1);
    }

}
