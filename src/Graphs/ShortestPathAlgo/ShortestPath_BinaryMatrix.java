package Graphs.ShortestPathAlgo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPath_BinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid == null || grid[0][0]==1){
            return -1;
        }

        PriorityQueue<Cell>  pq = new PriorityQueue<>((a,b)-> Integer.compare(a.dist, b.dist));
        int m = grid.length;;
        int n = grid[0].length;

        int[][] shortest_dist = new int[m][n];

        for(int[] a : shortest_dist){
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        shortest_dist[0][0] =1;

        pq.add(new Cell(0,0,1));

        while (!pq.isEmpty()){
            Cell currentcell = pq.poll();
            int currentx = currentcell.x;
            int currenty = currentcell.y;
            int current_dist = currentcell.dist;

            if(currentx == m-1 && currenty == n-1){
                return current_dist;
            }

            for( int i= -1; i<=1; i++){
                for(int j= -1; j<=1; j++){
                    int newx = currentx+i;
                    int newy = currenty+j;
                    if(newx >= 0 && newx < m && newy >=0 && newy < n){
                        int newdist = Math.min(current_dist+1, shortest_dist[newx][newy]);
                        if( newdist< shortest_dist[newx][newy] && grid[newx][newy]==0){
                            shortest_dist[newx][newy] = newdist;
                            pq.add(new Cell(newx, newy, newdist));
                            grid[newx][newy]=1;
                        }
                    }
                }
            }
        }

 return -1;
    }
}

class Cell {

    int x;
    int y;
    int dist;

    public Cell(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
