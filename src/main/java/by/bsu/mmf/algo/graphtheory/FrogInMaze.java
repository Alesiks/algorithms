package by.bsu.mmf.algo.graphtheory;

import java.util.*;

/**
 * task from HackerRank
 * Markov chain is used to solve the problem
 * <p>
 * Alef the Frog is in a two-dimensional maze represented as a table.
 * The maze has the following characteristics:
 *  Each cell can be free or can contain an obstacle, an exit, or a mine.
 *  Any two cells in the table considered adjacent if they share a side.
 *  The maze is surrounded by a solid wall made of obstacles.
 *  Some pairs of free cells are connected by a bidirectional tunnel.
 *  When Alef is in any cell, he can randomly and with equal probability choose to move into one of the adjacent cells
 *  that don't contain an obstacle in it.
 *  When Alef lands on a cell with an entrance to a tunnel, he is immediately transported through the tunnel
 *  and is thrown into the cell at the other end of the tunnel. It's possible for Alef to get stuck in the maze
 *  in the case when the cell in which he was thrown into from a tunnel is surrounded by obstacles on all sides.
 *  If this cell contains a mine, the mine explodes and Alef dies. If this cell contains an exit, then Alef escapes the maze.
 *
 *  Test case:
 *  7 7 2
 * O**%**O
 * OOOOOOO
 * OOO*OOO
 * **OA###
 * OOOO#OO
 * O*OO#O%
 * OOOO#OO
 * 1 1 7 7
 * 6 4 6 6
 * Expected output: 0.1334435980
 *
 * <p>
 * Your task is to write a program which calculates and prints a probability that Alef escapes the maze.
 */
public class FrogInMaze {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int trMatrixSize = n * m;
        double[] initialVector = new double[trMatrixSize];

        CellType[][] cellTypes = new CellType[n][m];
        Set<Integer> escapePositions = new HashSet<>();

        for (int a0 = 0; a0 < n; a0++) {
            String row = in.next();
            int pos;
            for (int chIndex = 0; chIndex < row.length(); chIndex++) {
                char ch = row.charAt(chIndex);
                switch (ch) {
                    case '%':
                        cellTypes[a0][chIndex] = CellType.EXIT;
                        pos = a0 * m + chIndex;
                        escapePositions.add(pos);
                        break;
                    case '*':
                        cellTypes[a0][chIndex] = CellType.MINE;
                        break;
                    case 'O':
                        cellTypes[a0][chIndex] = CellType.EMPTY;
                        break;
                    case '#':
                        cellTypes[a0][chIndex] = CellType.OBSTACLE;
                        break;
                    case 'A':
                        cellTypes[a0][chIndex] = CellType.EMPTY;
                        pos = a0 * m + chIndex;
                        initialVector[pos] = 1;
                        break;
                }
            }
        }
        Map<Cell, Cell> tunnels = new HashMap<>();
        for (int a0 = 0; a0 < k; a0++) {
            int i1 = in.nextInt();
            int j1 = in.nextInt();
            int i2 = in.nextInt();
            int j2 = in.nextInt();

            tunnels.put(new Cell(i1 - 1, j1 - 1), new Cell(i2 - 1, j2 - 1));
            tunnels.put(new Cell(i2 - 1, j2 - 1), new Cell(i1 - 1, j1 - 1));
        }

        double[][] transitionMatrix = initializeTransitionMatrix(cellTypes, tunnels, trMatrixSize);

        double[] resultVector = calculateProbabilities(transitionMatrix, initialVector);

        System.out.println(getEscapeProbability(resultVector, escapePositions));
    }

    private static double[][] initializeTransitionMatrix(CellType[][] cellTypes, Map<Cell, Cell> tunnels, int trMatrixSize) {
        double[][] transitionMatrix = new double[trMatrixSize][trMatrixSize];
        int trMatrixI = 0;
        for (int i = 0; i < cellTypes.length; i++) {
            for (int j = 0; j < cellTypes[i].length; j++) {
                double p = 1;
                if (CellType.OBSTACLE == cellTypes[i][j] || CellType.MINE == cellTypes[i][j] || CellType.EXIT == cellTypes[i][j]) {
                    transitionMatrix[trMatrixI][trMatrixI] = p;
                } else if (CellType.EMPTY == cellTypes[i][j]) {
                    List<Cell> possiblePositions = getPossiblePositions(cellTypes, i, j, tunnels);
                    if (possiblePositions.size() != 0) {
                        p = (double) 1 / (double) possiblePositions.size();
                        for (Cell pos : possiblePositions) {
                            int trMatrixJ = pos.getI() * cellTypes[0].length + pos.getJ();
                            transitionMatrix[trMatrixI][trMatrixJ] = p;
                        }
                    } else {
                        transitionMatrix[trMatrixI][trMatrixI] = p;
                    }
                }
                trMatrixI++;
            }
        }
        return transitionMatrix;
    }

    private static List<Cell> getPossiblePositions(CellType[][] cellTypes, int i, int j, Map<Cell, Cell> tunnels) {
        List<Cell> possiblePositions = new LinkedList<>();

        if (i - 1 >= 0 && cellTypes[i - 1][j] != CellType.OBSTACLE) {
            Cell cell = getCell(i - 1, j, tunnels);
            possiblePositions.add(cell);
        }
        if (i + 1 <= cellTypes.length - 1 && cellTypes[i + 1][j] != CellType.OBSTACLE) {
            Cell cell = getCell(i + 1, j, tunnels);
            possiblePositions.add(cell);
        }
        if (j - 1 >= 0 && cellTypes[i][j - 1] != CellType.OBSTACLE) {
            Cell cell = getCell(i, j - 1, tunnels);
            possiblePositions.add(cell);
        }
        if (j + 1 <= cellTypes[0].length - 1 && cellTypes[i][j + 1] != CellType.OBSTACLE) {
            Cell cell = getCell(i, j + 1, tunnels);
            possiblePositions.add(cell);
        }

        return possiblePositions;
    }

    private static Cell getCell(int i, int j, Map<Cell, Cell> tunnels) {
        Cell beforeTunnel = new Cell(i, j);
        Cell afterTunnel = tunnels.get(beforeTunnel);

        Cell nextCell;
        if (afterTunnel != null) {
            nextCell = afterTunnel;
        } else {
            nextCell = beforeTunnel;
        }
        return nextCell;
    }

    private static double getEscapeProbability(double[] resultVector, Set<Integer> escapePositions) {
        double escapeProbability = 0;
        for (int i = 0; i < resultVector.length; i++) {
            if (escapePositions.contains(i)) {
                escapeProbability += resultVector[i];
            }
        }
        return escapeProbability;
    }

    private static double[] calculateProbabilities(double[][] transitionMatrix, double[] initialVector) {
        double[][] transitionMatrixSquared = squareTheMatrix(transitionMatrix);
        for(int i = 0; i < 15; i++) {
            transitionMatrixSquared = squareTheMatrix(transitionMatrixSquared);
        }
        double[] resVector = multiplyVectorByMatrix(initialVector, transitionMatrixSquared);
        return resVector;
    }

    private static double[][] squareTheMatrix(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Wrong matrix dimensions");
        }

        double[][] squaredMatrix = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                double value = 0;
                for (int k = 0; k < matrix.length; k++) {
                    value += matrix[i][k] * matrix[k][j];
                }
                squaredMatrix[i][j] = value;
            }
        }

        return squaredMatrix;
    }

    private static double[] multiplyVectorByMatrix(double[] vector, double[][] matrix) {
        if (vector.length != matrix.length) {
            throw new RuntimeException("Wrong matrix dimensions");
        }

        double[] resVector = new double[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            double value = 0;
            for (int j = 0; j < vector.length; j++) {
                value += vector[j] * matrix[j][i];

            }
            resVector[i] = value;
        }

        return resVector;
    }

}


class Cell {

    private int i;

    private int j;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return i == cell.i &&
                j == cell.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

enum CellType {
    EXIT, MINE, EMPTY, OBSTACLE;
}
