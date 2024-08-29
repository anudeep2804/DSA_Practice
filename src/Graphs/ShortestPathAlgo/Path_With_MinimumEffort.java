package Graphs.ShortestPathAlgo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Path_With_MinimumEffort {

    public int minimumEffortPath(int[][] heights) {

        PriorityQueue<PathNode> priorityQueue = new PriorityQueue<>((a, b)-> Integer.compare(a.effort, b.effort));
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effortMatrix  = new int[rows][cols];

        for(int[] a : effortMatrix){
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        priorityQueue.add(new PathNode(0,0,0));
        effortMatrix[0][0]=0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!priorityQueue.isEmpty()){
            PathNode currentnode = priorityQueue.poll();
            int r = currentnode.x;
            int c = currentnode.y;
            int currenteffort = currentnode.effort;

            if(r==rows-1 && c == cols-1){
                return currenteffort;
            }

            for(int[] dir : directions){
                int newRow = r+ dir[0];
                int newCol = c + dir[1];

                if(newRow >=0 && newRow < rows && newCol <= cols && newCol >=0){
                    int newEffort = Math.max(currenteffort, Math.abs(heights[newRow][newCol] - heights[r][c]));
                    
                    if(newEffort < effortMatrix[newRow][newCol]){
                        effortMatrix[newRow][newCol] = newEffort;
                        priorityQueue.add(new PathNode(newRow, newCol, newEffort));
                    }
                }
            }
        }
        
        return -1;
    }
}

class PathNode {
    int x;
    int y;
    int effort;

    public PathNode(int x, int y, int effort) {
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
}
