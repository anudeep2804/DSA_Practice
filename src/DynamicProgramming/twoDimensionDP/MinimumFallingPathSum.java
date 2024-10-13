package DynamicProgramming.twoDimensionDP;

import java.util.Arrays;

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];


        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, minFallingPathSum(matrix, dp, 0, j));
        }

        return minPathSum;
    }

    private int minFallingPathSum(int[][] matrix, int[][] dp, int i, int j) {

        int m = matrix.length;
        int n = matrix[0].length;


        if (j < 0 || j >= n) {
            return 100000;
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }


        if (i == m - 1) {
            dp[i][j] = matrix[i][j];
            return dp[i][j];
        }

        int downLeft = minFallingPathSum(matrix, dp, i + 1, j - 1);
        int down = minFallingPathSum(matrix, dp, i + 1, j);
        int downRight = minFallingPathSum(matrix, dp, i + 1, j + 1);


        int minValue = Math.min(downLeft, Math.min(down, downRight));

        dp[i][j] = matrix[i][j] + minValue;

        return dp[i][j];
    }


}
