package Graphs;

public class Flood_Fill_Algorithm {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        boolean visited[][] = new boolean[m][n];

        int currentcolor = image[sr][sc];

        dfs(image, sr,sc, color, currentcolor, visited);

        return image;

    }

    private void dfs(int[][] image, int i, int j, int color, int currentcolor, boolean[][] visited) {

        if(i<0 || i>= image.length || j>= image[0].length || j<0 || visited[i][j]==true || image[i][j] !=currentcolor){
            return;
        }

        visited[i][j]=true;
        image[i][j]=color;

        dfs(image, i+1, j , color , currentcolor , visited);
        dfs(image, i-1, j , color , currentcolor , visited);
        dfs(image, i, j+1 , color , currentcolor , visited);
        dfs(image, i, j-1 , color , currentcolor , visited);

    }
}
