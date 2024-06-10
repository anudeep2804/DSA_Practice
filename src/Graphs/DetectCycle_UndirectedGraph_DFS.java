package Graphs;

import java.util.ArrayList;

/**
 * DetectCycle_UndirectedGraph_DFS is a utility class to detect cycles in an undirected graph using Depth-First Search (DFS).
 * The approach involves traversing each node and checking for cycles recursively.
 *
 * Pseudocode:
 * 1. Initialize a visited array to keep track of visited nodes.
 * 2. Iterate through each node. If a node is not visited, call the DFS function.
 * 3. In the DFS function, mark the current node as visited.
 * 4. Recursively visit all adjacent nodes. If an adjacent node is visited and is not the parent of the current node, a cycle is detected.
 * 5. If no cycles are detected during the DFS traversal, return false.
 *
 * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
 * Space Complexity: O(V), for the visited array and the recursion stack.
 */
public class DetectCycle_UndirectedGraph_DFS {

    static boolean checkForCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to keep track of visited vertices
        boolean[] visited = new boolean[V];

        // Traverse each vertex
        for (int i = 0; i < V; i++) {
            // If the vertex is not visited, perform DFS
            if (!visited[i]) {
                // If a cycle is detected, return true
                if (dfs(i, adj, visited, -1)) return true;
            }
        }

        // If no cycle is detected, return false
        return false;
    }


    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        // Mark the current vertex as visited
        visited[v] = true;

        // Traverse all the adjacent vertices
        for (Integer neighbor : adj.get(v)) {
            // If the adjacent vertex is not visited, perform DFS recursively
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, v))
                    return true;
            }
            // If the adjacent vertex is visited and is not the parent of the current vertex, a cycle is detected
            else if (parent != neighbor) {
                return true;
            }
        }

        // If no cycle is detected, return false
        return false;
    }
}
