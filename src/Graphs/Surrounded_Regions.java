package Graphs;

public class Surrounded_Regions {
    /**
     * Perform Depth-First Search (DFS) to mark 'O' regions connected to the border.
     * This ensures that any 'O' that is connected to the border is not surrounded by 'X'.
     *
     * Detailed Pseudocode:
     * 1. Check if the current cell (i, j) is out of bounds, already visited, or contains 'X':
     *    - If i < 0 or j < 0 or i >= m or j >= n, the cell is out of bounds.
     *    - If vis[i][j] is true, the cell has already been visited.
     *    - If board[i][j] is 'X', the cell contains 'X' and should not be processed.
     *    In any of these cases, return immediately as no further processing is needed.
     * 2. Mark the current cell (i, j) as visited by setting vis[i][j] to true.
     * 3. Recursively call DFS for all 4 adjacent cells:
     *    - Call dfs(board, vis, i + 1, j, m, n) to process the cell below the current cell.
     *    - Call dfs(board, vis, i - 1, j, m, n) to process the cell above the current cell.
     *    - Call dfs(board, vis, i, j + 1, m, n) to process the cell to the right of the current cell.
     *    - Call dfs(board, vis, i, j - 1, m, n) to process the cell to the left of the current cell.
     *    This step ensures that all 'O's connected to the current 'O' are marked as visited.
     */
    public void dfs(char[][] board, boolean[][] vis, int i, int j, int m, int n) {
        // Base case: if the current cell is out of bounds, already visited, or an 'X', return
        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || board[i][j] == 'X')
            return;

        // Mark the current cell as visited
        vis[i][j] = true;

        // Recursively visit all 4 adjacent cells (up, down, left, right)
        dfs(board, vis, i + 1, j, m, n);
        dfs(board, vis, i - 1, j, m, n);
        dfs(board, vis, i, j + 1, m, n);
        dfs(board, vis, i, j - 1, m, n);
    }

    /**
     * Main method to solve the 'Surrounded Regions' problem.
     * The goal is to capture all regions surrounded by 'X' and convert them to 'X'.
     * Regions connected to the border should remain as 'O'.
     *
     * Detailed Pseudocode:
     * 1. Initialize a visited array 'vis' to keep track of visited cells.
     * 2. Traverse the first and last row of the board:
     *    - For each column j in the first row (i = 0):
     *      - If board[0][j] is 'O' and vis[0][j] is false, call dfs(board, vis, 0, j, m, n).
     *        This marks all 'O' regions connected to the top border.
     *    - For each column j in the last row (i = m - 1):
     *      - If board[m - 1][j] is 'O' and vis[m - 1][j] is false, call dfs(board, vis, m - 1, j, m, n).
     *        This marks all 'O' regions connected to the bottom border.
     * 3. Traverse the first and last column of the board:
     *    - For each row i in the first column (j = 0):
     *      - If board[i][0] is 'O' and vis[i][0] is false, call dfs(board, vis, i, 0, m, n).
     *        This marks all 'O' regions connected to the left border.
     *    - For each row i in the last column (j = n - 1):
     *      - If board[i][n - 1] is 'O' and vis[i][n - 1] is false, call dfs(board, vis, i, n - 1, m, n).
     *        This marks all 'O' regions connected to the right border.
     * 4. Traverse the entire board:
     *    - For each cell (i, j):
     *      - If board[i][j] is 'O' and vis[i][j] is false, it means this 'O' is surrounded by 'X'.
     *        Change board[i][j] to 'X' to capture the region.
     */
    public void solve(char[][] board) {
        int m = board.length;     // Number of rows
        int n = board[0].length;  // Number of columns
        boolean[][] vis = new boolean[m][n]; // Visited array to keep track of visited cells

        // Step 2: Traverse the first and last row
        for (int j = 0; j < n; j++) {
            // If an 'O' is found on the first row and it is not visited, start DFS
            if (board[0][j] == 'O' && !vis[0][j])
                dfs(board, vis, 0, j, m, n);
            // If an 'O' is found on the last row and it is not visited, start DFS
            if (board[m - 1][j] == 'O' && !vis[m - 1][j])
                dfs(board, vis, m - 1, j, m, n);
        }

        // Step 3: Traverse the first and last column
        for (int i = 0; i < m; i++) {
            // If an 'O' is found on the first column and it is not visited, start DFS
            if (board[i][0] == 'O' && !vis[i][0])
                dfs(board, vis, i, 0, m, n);
            // If an 'O' is found on the last column and it is not visited, start DFS
            if (board[i][n - 1] == 'O' && !vis[i][n - 1])
                dfs(board, vis, i, n - 1, m, n);
        }

        // Step 4: Convert all unvisited 'O' cells to 'X' (since they are surrounded)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
