package twoDimensionDP;

import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return memo(obstacleGrid, m, n, 0,0,dp);
    }

    int memo(int[][] obstaclegrid , int m, int n, int i, int j, int[][] dp) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if(obstaclegrid[i][j]==1){
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = memo(obstaclegrid, m, n, i + 1, j, dp) + memo(obstaclegrid, m, n, i, j + 1, dp);

        return dp[i][j];
    }
}
