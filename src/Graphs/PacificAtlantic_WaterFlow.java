package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/

public class PacificAtlantic_WaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 1. Initialize variables
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols]; // Whether each cell can flow to the Pacific Ocean
        boolean[][] atl = new boolean[rows][cols]; // Whether each cell can flow to the Atlantic Ocean

        // 2. Iterate over columns on top and bottom rows
        for (int col = 0; col < cols; col++) {
            // 3. Perform Depth-First Search (DFS) from top row
            dfs(0, col, rows, cols, pac, heights[0][col], heights);
            // 4. Perform Depth-First Search (DFS) from bottom row
            dfs(rows - 1, col, rows, cols, atl, heights[rows - 1][col], heights);
        }
        // 5. Iterate over rows on left and right columns
        for (int row = 0; row < rows; row++) {
            // 6. Perform Depth-First Search (DFS) from left column
            dfs(row, 0, rows, cols, pac, heights[row][0], heights);
            // 7. Perform Depth-First Search (DFS) from right column
            dfs(row, cols - 1, rows, cols, atl, heights[row][cols - 1], heights);
        }

        // 8. Initialize result list
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 9. Iterate over each cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 10. If a cell can flow to both oceans, add its coordinates to the result list
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        // 11. Return the result list
        return result;
    }

    // DFS method to explore cells that can be reached from a given cell
    private void dfs(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights) {
        // Base case: If the cell is out of bounds, already visited, or higher than previous height, stop DFS
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || prevHeight > heights[row][col]) {
            return;
        }
        // Mark the cell as visited
        visited[row][col] = true;
        // Recursively explore adjacent cells in four directions
        dfs(row + 1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row - 1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col + 1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col - 1, rows, cols, visited, heights[row][col], heights);
    }
}
