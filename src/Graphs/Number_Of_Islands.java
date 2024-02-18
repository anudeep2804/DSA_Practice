package Graphs;

public class Number_Of_Islands {

    //https://leetcode.com/problems/number-of-islands/
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int result =0;

        boolean visited[][] = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid, visited);
                    result++;
                }
            }
        }

         return result;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {

        if(i<0 || i>= grid.length || j>= grid[0].length || j<0 || visited[i][j]==true){
            return;
        }

        visited[i][j]=true;

        if(grid[i][j]=='0'){
            return;
        }

        dfs(i+1, j, grid , visited);
        dfs(i-1, j, grid,visited);
        dfs(i, j+1, grid, visited);
        dfs(i, j-1, grid, visited);

    }
}
