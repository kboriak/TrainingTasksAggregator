package ua.kharkiv.kboriak.hackerrank.contests.projecteuler.project197;

import ua.kharkiv.kboriak.utils.annotations.Unsolved;

import java.util.Scanner;

// https://www.hackerrank.com/contests/projecteuler/challenges/euler197/problem
@Unsolved
public class InvestigatingRecursiveSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s+");
        double u0 = scanner.nextDouble();
        double b = scanner.nextDouble();
        scanner.close();
        double power = Math.pow(10, -9);
        double u1;
        double u2 = u0;
        do {
            u1 = u2;
            u2 = Math.floor(Math.pow(2, b - u1 * u1)) * power;
        } while(Math.abs(u2 - u1) > power * 2);
        System.out.printf("%.9f", u2 + u1);
    }
}
