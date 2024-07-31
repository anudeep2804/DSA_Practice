package Graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_Detection_DirectedGraph_BFS {

    // For a given DAG if the toposort size is not 'n' then it has a cycle

    public boolean iscyclic (int V , ArrayList<ArrayList<Integer>> adj){

        int[] indegree = new int[V];

        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) queue.offer(it);
            }
        }

        return count == V;

    }
}
