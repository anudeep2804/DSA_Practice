package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Zero_One_Matrix {

    // Method to update the matrix with the distance to the nearest 0 for each cell
    public int[][] updateMatrix(int[][] mat) {
        // Check if the matrix is null or empty
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0][0];
        }

        int m = mat.length;  // Number of rows
        int n = mat[0].length;  // Number of columns
        Queue<int[]> queue = new LinkedList<>();  // Queue for BFS
        int MAX_VALUE = m * n;  // Maximum possible distance

        // Initialize the queue and the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // Add cells with 0 to the queue
                    queue.offer(new int[]{i, j});
                } else {
                    // Set cells with 1 to a large value (indicating they need to be updated)
                    mat[i][j] = MAX_VALUE;
                }
            }
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS to update distances
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();  // Get the current cell from the queue
            for (int[] dir : directions) {
                int r = cell[0] + dir[0];  // Calculate the new row index
                int c = cell[1] + dir[1];  // Calculate the new column index
                // Check if the new cell is within bounds and if we found a shorter path
                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[cell[0]][cell[1]] + 1) {
                    // Update the distance for the new cell
                    queue.offer(new int[]{r, c});  // Add the new cell to the queue
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;  // Update the distance
                }
            }
        }

        return mat;  // Return the updated matrix
    }
}

