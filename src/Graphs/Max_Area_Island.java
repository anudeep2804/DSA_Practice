package Graphs;

public class Max_Area_Island {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans = Math.max(dfs(grid, visited, i, j), ans);
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;

        int area = 1;
        area += dfs(grid, visited, i + 1, j);
        area += dfs(grid, visited, i - 1, j);
        area += dfs(grid, visited, i, j + 1);
        area += dfs(grid, visited, i, j - 1);

        return area;
    }
}
