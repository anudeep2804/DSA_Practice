package Graphs;


class Count_islands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;

        boolean[][] visited_grid2 = new boolean[grid2.length][grid2[0].length];
        boolean[][] landSpots_grid1 = new boolean[grid1.length][grid1[0].length];

        // First pass: mark all land spots in grid1
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 1 && !landSpots_grid1[i][j]) {
                    dfs(i, j, grid1, landSpots_grid1);
                }
            }
        }

        // Second pass: check potential sub-islands in grid2
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && !visited_grid2[i][j]) {
                    if (dfs2(i, j, grid2, visited_grid2, landSpots_grid1)) {
                        result++; // Increment result if dfs2 confirms a sub-island
                    }
                }
            }
        }

        return result;
    }

    private boolean dfs2(int i, int j, int[][] grid2, boolean[][] visitedGrid2, boolean[][] landSpotsGrid1) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || visitedGrid2[i][j] || grid2[i][j] == 0) {
            return true;
        }

        visitedGrid2[i][j] = true;

        // Check if this part of grid2 is on land in grid1
        boolean isSubIsland = landSpotsGrid1[i][j];

        // Continue DFS only if currently on a valid sub-island part
        isSubIsland &= dfs2(i + 1, j, grid2, visitedGrid2, landSpotsGrid1);
        isSubIsland &= dfs2(i - 1, j, grid2, visitedGrid2, landSpotsGrid1);
        isSubIsland &= dfs2(i, j + 1, grid2, visitedGrid2, landSpotsGrid1);
        isSubIsland &= dfs2(i, j - 1, grid2, visitedGrid2, landSpotsGrid1);

        return isSubIsland;
    }

    private void dfs(int i, int j, int[][] grid1, boolean[][] landSpotsGrid1) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || landSpotsGrid1[i][j] || grid1[i][j] == 0) {
            return;
        }

        landSpotsGrid1[i][j] = true;

        dfs(i + 1, j, grid1, landSpotsGrid1);
        dfs(i - 1, j, grid1, landSpotsGrid1);
        dfs(i, j + 1, grid1, landSpotsGrid1);
        dfs(i, j - 1, grid1, landSpotsGrid1);
    }
}

