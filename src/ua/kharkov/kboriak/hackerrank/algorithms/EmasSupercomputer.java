package ua.kharkov.kboriak.hackerrank.algorithms;

import java.util.*;

// https://www.hackerrank.com/challenges/two-pluses/problem
public class EmasSupercomputer {
    private static int n;
    private static int m;
    private static boolean[][] grid;

    private static class Node {
        private final int x;
        private final int y;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static class Crest {
        private final Set<Node> nodes;
        private final int square;

        private Crest(Set<Node> nodes) {
            this.nodes = nodes;
            this.square = nodes.size();

        }

        private boolean hasNoCommonNodes(Crest crest) {
            return Collections.disjoint(nodes, crest.nodes);
        }
    }

    private static int recursiveCheck(int i, int j, int x, int y) {
        i += x;
        j += y;
        boolean vertical = (i >= 0) && (i < n);
        boolean horizontal = (j >= 0) && (j < m);
        if (vertical && horizontal && grid[i][j]) {
            return 1 + recursiveCheck(i, j, x, y);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nAndM = scanner.nextLine().split("\\s+");
        n = Integer.valueOf(nAndM[0]);
        m = Integer.valueOf(nAndM[1]);
        grid = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] gridLine = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                grid[i][j] = gridLine[j] == 'G';
            }
        }
        scanner.close();

        List<Crest> crests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    int up = recursiveCheck(i, j, -1, 0);
                    int down = recursiveCheck(i, j, 1, 0);
                    int left = recursiveCheck(i, j, 0, -1);
                    int right = recursiveCheck(i, j, 0, 1);
                    int minLength = Math.min(Math.min(up, down), Math.min(left, right));
                    Set<Node> nodes = new HashSet<>();
                    nodes.add(new Node(i, j));
                    crests.add(new Crest(nodes));
                    for (int k = 1; k <= minLength; k++) {
                        nodes = new HashSet<>(nodes);
                        nodes.add(new Node(i - k, j));
                        nodes.add(new Node(i + k, j));
                        nodes.add(new Node(i, j - k));
                        nodes.add(new Node(i, j + k));
                        crests.add(new Crest(nodes));
                    }
                }
            }
        }

        Set<Integer> results = new HashSet<>();
        for (Crest crest1 : crests) {
            for (Crest crest2 : crests) {
                if (crest1 != crest2 && crest1.hasNoCommonNodes(crest2)) {
                    results.add(crest1.square * crest2.square);
                }
            }
        }

        System.out.println(Collections.max(results));
    }
}
