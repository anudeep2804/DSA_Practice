package Graphs.topologicalSort;


import java.util.*;
import java.lang.*;

class topoLogicalSort
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)

    {

        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i, visited, adj, stack);
            }
        }

        int[] ans = new int[V];

        int j=0;

        while(!stack.isEmpty()){

            ans[j++]= stack.peek();

            stack.pop();

        }

        return ans;
    }

    static void dfs(int node, boolean[] visited,
                    ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        visited[node] = true;

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, adj, stack);
            }
        }

        stack.push(node);
    }
}

