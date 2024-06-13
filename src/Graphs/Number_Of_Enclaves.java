package Graphs;

public class Number_Of_Enclaves {

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        int result = 0;

        // Traverse the first row
        for (int j = 0; j < m; j++) {
            dfs(0, j, visited, grid);
        }

        // Traverse the last row
        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, visited, grid);
        }

        // Traverse the first column
        for (int i = 1; i < n - 1; i++) {
            dfs(i, 0, visited, grid);
        }

        // Traverse the last column
        for (int i = 1; i < n - 1; i++) {
            dfs(i, m - 1, visited, grid);
        }

        // Count the enclaves
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    public void dfs(int i, int j, boolean[][] visited, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        grid[i][j] = Integer.MAX_VALUE;

        dfs(i - 1, j, visited, grid);
        dfs(i + 1, j, visited, grid);
        dfs(i, j - 1, visited, grid);
        dfs(i, j + 1, visited, grid);
    }

}
