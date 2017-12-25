package ua.kharkiv.kboriak.hackerrank.contests.projecteuler.project197;

import java.util.Scanner;

// https://www.hackerrank.com/contests/projecteuler/challenges/euler197/problem
public class InvestigatingRecursiveSequence {

    private static double sumOfTwoLastElementsInSequence(double u0, double b, double error) {
        double u1 = Double.MIN_VALUE;
        double u2 = u0;
        double temp;
        do {
            temp = u1;
            u1 = u2;
            u2 = nextInSequence(u1, b);
            if (temp == u2) {
                break;
            }
        } while (Math.abs(u2 - u1) > error);
        return u1 + u2;
    }

    private static double nextInSequence(double x, double b) {
        return Math.floor(Math.pow(2, b - x * x)) * 0.000000001;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double u0 = scanner.nextDouble();
        double b = scanner.nextDouble();
        scanner.close();
        System.out.printf("%.9f", sumOfTwoLastElementsInSequence(u0, b, Math.pow(10, -8)));
    }
}
