package by.bsu.mmf.algo.dynamic;

public class LongestCommonSubsequence {

    public int[] get(int[] a, int[] b) {
        int[][] dpMatrix = new int[a.length + 1][b.length + 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    dpMatrix[i + 1][j + 1] = dpMatrix[i][j] + 1;
                } else {
                    dpMatrix[i + 1][j + 1] = Math.max(dpMatrix[i + 1][j], dpMatrix[i][j + 1]);
                }
            }
        }

        int i = a.length;
        int j = b.length;
        int elementPos = dpMatrix[a.length][b.length] - 1;

        int[] restoredSubsequence = new int[elementPos];
        while (i > 0 && j > 0) {
            if (dpMatrix[i][j] == dpMatrix[i][j - 1]) {
                j--;
            } else if (dpMatrix[i][j] == dpMatrix[i - 1][j]) {
                i--;
            } else if (dpMatrix[i][j] == dpMatrix[i - 1][j - 1] + 1) {
                restoredSubsequence[elementPos - 1] = a[i - 1];
                i--;
                j--;
                elementPos--;
            }
        }
        return restoredSubsequence;
    }

}
