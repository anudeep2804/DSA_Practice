package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs_BFS_Implementation {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> list_bfs = new ArrayList<>();

        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);


        while(!queue.isEmpty()){

            Integer currentnode = queue.poll();
            visited[currentnode] = true;

            list_bfs.add(currentnode);


            for( Integer it : adj.get(currentnode)){
                if(visited[it]==false){
                    visited[it]=true;
                    queue.add(it);
                }
            }
        }

        return list_bfs;

    }
}
