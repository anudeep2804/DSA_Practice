package Graphs.ShortestPathAlgo;

import java.util.*;

class Dijkstra_Algo {

    static class Node implements Comparable<Node> {
        int vertex, distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int src, int[] parent) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Arrays.fill(parent, -1); // Initialize parent array

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.distance;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u; // Update parent
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }

    // Function to print the shortest path from source to vertex 'v'
    public static void printPath(int[] parent, int v) {
        if (v == -1) {
            return;
        }
        printPath(parent, parent[v]);
        System.out.print(v + " ");
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        int[] parent = new int[V]; // Array to store the shortest path tree
        int[] distances = dijkstra(V, adj, 0, parent);

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> Distance: " + distances[i]);
            System.out.print("Path: ");
            printPath(parent, i);
            System.out.println();
        }
    }
}
