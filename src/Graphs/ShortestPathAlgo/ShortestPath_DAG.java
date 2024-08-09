package Graphs.ShortestPathAlgo;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ShortestPath_DAG obj = new ShortestPath_DAG();
        int res[] = obj.shortestPath(edge, n, m, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
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
