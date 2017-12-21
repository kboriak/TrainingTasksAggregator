package ua.kharkov.kboriak.hackerrank.contests.worldcodesprint12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/red-knights-shortest-path
public class RedKnightsShortestPath {

    private enum Directions {
        UL("UL"), UR("UR"), R("R"), LR("LR"), LL("LL"), L("L");
        private String directionName;

        Directions(String directionName) {
            this.directionName = directionName;
        }

        @Override
        public String toString() {
            return directionName;
        }
    }

    static void printShortestPath(int n, int startRow, int startColumn, int endRow, int endColumn) {
        int dRow = Math.abs(startRow - endRow);
        int dColumn = Math.abs(startColumn - endColumn);
        if (dRow % 2 != 0 || dColumn % 2 != (dRow % 4) / 2) {
            System.out.println("Impossible");
            return;
        }

        int currentRow = startRow;
        int currentColumn = startColumn;
        List<Directions> directions = new ArrayList<>();
        while (!(currentRow == endRow && currentColumn == endColumn)) {
            if (currentRow == endRow && currentColumn > endColumn) {
                directions.add(Directions.L);
                currentColumn -= 2;
            } else if (currentRow == endRow && currentColumn < endColumn) {
                directions.add(Directions.R);
                currentColumn += 2;
            } else if (currentRow > endRow && currentColumn >= endColumn) {
                directions.add(Directions.UL);
                currentRow -= 2;
                currentColumn -= 1;
            } else if (currentRow > endRow && currentColumn < endColumn) {
                directions.add(Directions.UR);
                currentRow -= 2;
                currentColumn += 1;
            } else if (currentRow < endRow && currentColumn >= endColumn) {
                directions.add(Directions.LL);
                currentRow += 2;
                currentColumn -= 1;
            } else if (currentRow < endRow && currentColumn < endColumn) {
                directions.add(Directions.LR);
                currentRow += 2;
                currentColumn += 1;
            }
        }
        System.out.println(directions.size());
        directions.stream().sorted().forEach(direction -> System.out.print(direction + " "));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}
