package Graphs;

import java.util.*;


public class DetectedCycle_UndirectedGraph_BFS {

    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis, int parent[]) {
        // Create a queue for BFS
        Queue<Node> q = new LinkedList<>();
        // Add the source node to the queue with parent as -1 (no parent)
        q.add(new Node(s, -1));
        // Mark the source node as visited
        vis[s] = true;

        // Continue until the queue is empty
        while (!q.isEmpty()) {
            // Get the front node and its parent
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // Traverse all adjacent nodes
            for (Integer it : adj.get(node)) {
                // If the adjacent node is not visited, add it to the queue
                if (!vis[it]) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }
                // If the adjacent node is visited and not its own parent, cycle detected
                else if (par != it) return true;
            }
        }

        // If no cycle is detected, return false
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to keep track of visited nodes
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        // Array to keep track of parent nodes
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        // Check each vertex in the graph
        for (int i = 0; i < V; i++) {
            // If the vertex is not visited, start BFS from that vertex
            if (!vis[i]) {
                // If BFS finds a cycle, return true
                if (checkForCycle(adj, i, vis, parent)) return true;
            }
        }

        // If no cycles are found, return false
        return false;
    }

    public static void main(String[] args) {
        // Example graph with 4 vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        // Adding edges to the graph
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        // Create an instance of the class and check for cycles
        DetectedCycle_UndirectedGraph_BFS obj = new DetectedCycle_UndirectedGraph_BFS();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");  // Output 1 if cycle is detected
        else
            System.out.println("0");  // Output 0 if no cycle is detected
    }
}


class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
