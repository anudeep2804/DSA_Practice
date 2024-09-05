package Graphs.ShortestPathAlgo;

// Bellman-Ford Algorithm:
// 1. Used to find the shortest path from a single source to all other vertices in a weighted graph, only works for directed graphs.
// 2. Can handle graphs with negative weight edges, unlike Dijkstra's algorithm.
// 3. Time complexity: O(V * E), where V is the number of vertices and E is the number of edges.
// 4. Works by relaxing all edges up to V-1 times (where V is the number of vertices).
// 5. Detects negative weight cycles, making it useful for graphs where such cycles are present.

// Key differences between Bellman-Ford and Dijkstra's algorithm:
// - Bellman-Ford can handle negative weight edges, Dijkstra's cannot.
// - Bellman-Ford has a higher time complexity (O(V * E)) than Dijkstra's (O(V log V) with a priority queue).
// - Dijkstra's algorithm is more efficient for graphs with non-negative weights and is preferred for such cases.
// - Use Bellman-Ford when negative weights or negative cycles are present, and Dijkstra's when the graph has non-negative weights.


import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm   {

static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int src){

    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    // V*E, perform relaxation V-1 times

    for(int i=0; i<V-1; i++){
        for(ArrayList<Integer> it: edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if(dist[u]!= Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                dist[v]=dist[u]+wt;
            }
        }
    }

    // check if there is a cycle for Vth iteration

    for(ArrayList<Integer> it : edges){
        int u = it.get(0);
        int v = it.get(1);
        int wt = it.get(2);
        if(dist[u]!= Integer.MAX_VALUE && dist[u] + wt < dist[v]){
            return new int[]{-1};
        }
    }

    return dist;
}
}
