package Graphs.MinimumSpanningTrees;
/*
 *  Spanning Tree:
 *  --------------
 *  - A spanning tree of a graph is a subgraph that is a tree and connects all vertices together.
 *  - A graph can have many spanning trees, but a minimum spanning tree (MST) is the one with the minimum total edge weight.
 *  - The number of edges in a spanning tree is always (V - 1), where V is the number of vertices in the graph.
 *  - A minimum spanning tree ensures that the graph remains fully connected with the least possible total edge weight.
 *
 *  Prim's Algorithm:
 *  -----------------
 *  - Prim's algorithm is a greedy algorithm that builds the minimum spanning tree (MST) by starting from an arbitrary vertex
 *    and growing the MST one edge at a time.
 *  - The algorithm selects the edge with the smallest weight that connects a vertex in the MST to a vertex outside the MST.
 *  - It repeats this process until all vertices are included in the MST.
 *
 *  Steps to Implement Prim's Algorithm:
 *  ------------------------------------
 *  1. Start with an arbitrary vertex, and add it to the MST.
 *  2. Initialize a priority queue (or min-heap) to pick the edge with the minimum weight.
 *  3. For every vertex added to the MST, explore its adjacent vertices.
 *  4. If an adjacent vertex is not already in the MST and the edge connecting it has a smaller weight than its current
 *     known weight, update the weight and add the edge to the priority queue.
 *  5. Repeat steps 2-4 until all vertices are included in the MST.
 *  6. The result is the minimum spanning tree with the minimum possible total edge weight.
 *
 *  Time Complexity of Prim's Algorithm:
 *  ------------------------------------
 *  - Using a binary heap (PriorityQueue in Java):
 *    Time Complexity: O(E log V), where E is the number of edges and V is the number of vertices.
 *    The priority queue is used to get the minimum edge at each step, and updating the queue takes logarithmic time.
 *
 *  Space Complexity:
 *  -----------------
 *  - O(V + E), where V is the number of vertices and E is the number of edges. The space is needed to store the adjacency list,
 *    the priority queue, and the arrays to track visited vertices and minimum weights.
 */

import java.util.List;
import java.util.PriorityQueue;

import java.util.*;

public class PrimsAlgorithm {

    /**
     * Prim's Algorithm to find the minimum spanning tree (MST).
     *
     * @param V   No of Nodes
     * @param E   No of Edges (unused but might be used for validation)
     * @param adj Adjacency List where each element is a List of int[] representing {destination, weight}
     * @return    Total Weight of Minimum Spanning Tree
     */
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // PriorityQueue to select the next edge with the smallest weight
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[V];

        // Sum will store the total weight of the MST
        int sum = 0;

        // Start from node 0 with weight 0
        pq.add(new Node(0, 0));

        // Process the priority queue until it's empty
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currDest = currentNode.dest;
            int currWt = currentNode.weight;

            // If this node has already been visited, skip it
            if (visited[currDest]) continue;

            // Mark this node as visited
            visited[currDest] = true;

            // Add the weight of this edge to the total MST weight
            sum += currWt;

            // Explore all adjacent edges of the current node
            for (int[] temp : adj.get(currDest)) {
                int newDest = temp[0];
                int newWt = temp[1];

                // Only add unvisited nodes to the priority queue
                if (!visited[newDest]) {
                    pq.add(new Node(newDest, newWt));
                }
            }
        }


        return sum;
    }

    static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

}
