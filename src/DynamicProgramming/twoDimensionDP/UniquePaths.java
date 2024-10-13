package DynamicProgramming.twoDimensionDP;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

//      return memo(m, n, 0, 0, dp);

        return tabulation(m, n);
    }

    int memo(int m, int n, int i, int j, int[][] dp) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = memo(m, n, i + 1, j, dp) + memo(m, n, i, j + 1, dp);

        return dp[i][j];
    }

    int tabulation(int m, int n) {

        if (m == 1 && n == 1) return 1;

        int[][] dp = new int[m][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // fill the borders as we can always reach m-1, n-1 using border path

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
