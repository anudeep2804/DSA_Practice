package Graphs.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPath_DAG {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {

        if(edges == null) return  null;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            adj.get(source).add(new Pair(dest, weight));
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                topoSort(i, visited, adj, stack);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(node)) {
                    if (dist[node] + p.distance < dist[p.node]) {
                        dist[p.node] = dist[node] + p.distance;
                    }
                }
            }
        }

        return dist;
    }

    private void topoSort(int curr, boolean[] visited, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack) {

        visited[curr] = true;

        for(int i = 0; i < adj.get(curr).size(); i++){
            int node = adj.get(curr).get(i).node;
            if(!visited[node]) {
                topoSort(node, visited, adj, stack);  // Corrected to pass 'node' instead of 'curr'
            }
        }

        stack.push(curr);
    }
}

class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
