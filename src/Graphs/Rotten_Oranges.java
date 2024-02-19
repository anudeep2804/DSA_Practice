package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Rotten_Oranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid
        // Initialize visited array to track the state of each cell in the grid
        // Not using a separate visited array here, using 'grid' itself for simplicity
        int[][] visited = grid;
        Queue<int[]> q = new LinkedList<>(); // Queue to hold the cells with rotten oranges
        int countFreshOrange = 0; // Counter for fresh oranges

        // Iterate over the grid to find all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 2) { // If the orange is rotten, add it to the queue
                    q.offer(new int[] {i, j});
                }
                if (visited[i][j] == 1) { // If the orange is fresh, increment the counter
                    countFreshOrange++;
                }
            }
        }

        // If there are no fresh oranges, return 0 as no time is needed
        if (countFreshOrange == 0)
            return 0;
        // If there are no rotten oranges to spread the rot, return -1
        if (q.isEmpty())
            return -1;

        int minutes = -1; // Initialize minutes to -1 to account for the first minute correctly
        // Directions array to easily access all four adjacent cells (up, down, left, right)
        int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};

        // BFS starts here
        while (!q.isEmpty()) {
            int size = q.size(); // Current size of the queue
            // Process all cells in the queue (current wave of rot spreading)
            while (size-- > 0) {
                int[] cell = q.poll(); // Get the current cell from the queue
                int x = cell[0]; // Current cell's row
                int y = cell[1]; // Current cell's column
                // Try all four directions from the current cell
                for (int[] dir : dirs) {
                    int i = x + dir[0]; // New cell's row
                    int j = y + dir[1]; // New cell's column
                    // Check if the new cell is within the grid and has a fresh orange
                    if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2; // Mark the fresh orange as rotten
                        countFreshOrange--; // Decrement the count of fresh oranges
                        q.offer(new int[] {i, j}); // Add the new cell to the queue
                    }
                }
            }
            minutes++; // Increment the minutes after processing the current wave
        }

        // If there are no fresh oranges left, return the total minutes taken
        if (countFreshOrange == 0)
            return minutes;
        // If there are still fresh oranges left, return -1 as it's impossible to rot all oranges
        return -1;
    }
}

