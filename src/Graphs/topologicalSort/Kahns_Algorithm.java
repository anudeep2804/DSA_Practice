package Graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahns_Algorithm {

    // Function to return list of vertices in topological order

    static int[] toposort(int V, ArrayList<ArrayList<Integer>> adj) {

        int indegree[] = new int[V];

        for (int i = 0; i < adj.size(); i++) {
            for (int current : adj.get(i)) {
                indegree[current]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topo = new int[V];

        int i = 0;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            topo[i++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        return topo;

    }
}
