package Graphs.MinimumSpanningTrees;

import Graphs.DisjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal's Algorithm
 *
 * Notes:
 * - Finds the Minimum Spanning Tree (MST) of a graph.
 * - Uses a greedy approach by selecting the smallest edges first.
 * - Utilizes Union-Find to detect cycles.
 *
 * Pseudocode:
 * 1. Sort all edges in ascending order of weight.
 * 2. Initialize MST as empty.
 * 3. Create subsets for each vertex.
 * 4. For each edge in sorted order:
 *    a. If adding the edge doesn't form a cycle, include it in MST.
 *    b. Union the two vertices.
 * 5. Repeat until MST has (V-1) edges.
 */

public class Kruskals_Algorithm {

    static int spanningTree(int V, int E , List<List<int[]>> adj){

        List<Edge> edges = new ArrayList<>();

        for(int i=0; i<V; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                int[] current_edge = adj.get(i).get(j);
                int current_src = current_edge[0];
                int current_dest = current_edge[1];
                int current_weight = current_edge[2];

                edges.add(new Edge(current_src, current_dest, current_weight));
            }
        }

        Collections.sort(edges);

        int mst_weight = 0;

        DisjointSet ds = new DisjointSet(V);

        for(int i=0; i<edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if(ds.findUltimateParent(u) != ds.findUltimateParent(v)){
                mst_weight += wt;
                ds.unionBySize(u,v);
            }
        }

        return mst_weight;
    }




}

class Edge implements Comparable<Edge>{

    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
