package by.bsu.mmf.algo.graphtheory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * task from HackerRank
 * Depth first search is used to solve the problem
 * <p>
 * Consider a matrix where each cell contains either a 1 or a 0 and any cell containing a 1 is called a filled cell.
 * Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally.
 * Given an NxM matrix, find and print the number of cells in the largest connected component in a the matrix.
 */
public class ConnectedCellInAGrid {

    static int maxRegion(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] markedPoints = new boolean[n][m];

        int maxConnectedComponentSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!markedPoints[i][j] && grid[i][j] == 1) {

                    int connectedComponentSize = 0;
                    Deque<Point> dfsStack = new LinkedList<>();
                    Point startPoint = new Point(i, j);
                    markedPoints[i][j] = true;
                    dfsStack.push(startPoint);
                    while (!dfsStack.isEmpty()) {
                        Point currPoint = dfsStack.pop();
                        connectedComponentSize++;
                        traverseAdjacentCells(grid, markedPoints, dfsStack, currPoint, n, m);
                    }
                    maxConnectedComponentSize = Math.max(connectedComponentSize, maxConnectedComponentSize);

                }
            }
        }
        return maxConnectedComponentSize;
    }

    private static void traverseAdjacentCells(int[][] grid, boolean[][] markedPoints, Deque<Point> dfsStack, Point currPoint, int n, int m) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Point adjPoint = new Point(currPoint.x + i, currPoint.y + j);
                if (isValid(adjPoint, n, m)
                        && !isMarked(markedPoints, adjPoint)
                        && isFilled(grid, adjPoint)) {
                    dfsStack.push(adjPoint);
                    markPoint(markedPoints, adjPoint);
                }
            }
        }
    }

    private static boolean isValid(Point p, int n, int m) {
        return p.x >= 0 && p.y >= 0 && p.x < n && p.y < m;
    }

    private static boolean isMarked(boolean[][] markedPoints, Point p) {
        return markedPoints[p.x][p.y];
    }

    private static void markPoint(boolean[][] markedPoints, Point p) {
        markedPoints[p.x][p.y] = true;
    }

    private static boolean isFilled(int[][] grid, Point p) {
        return grid[p.x][p.y] == 1;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

