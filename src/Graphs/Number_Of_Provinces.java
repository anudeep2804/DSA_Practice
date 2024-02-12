package Graphs;
import java.util.*;

public class Number_Of_Provinces {

    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> queue = new LinkedList<>();

        int counter =0;

        for(int i=0; i<isConnected.length; i++){
            if(visited[i]==false){
                queue.offer(i);

                while(!queue.isEmpty()){
                    int currentnode = queue.poll();

                    visited[currentnode] = true;

                    for(int j=0; j<isConnected[0].length; j++){
                        if(isConnected[currentnode][j]==1 && visited[j]==false){
                            queue.offer(j);
                        }
                    }
                }

                counter++;
            }
        }


        return counter;
    }
}
