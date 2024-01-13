package Graphs;

import java.util.ArrayList;

public class Graph_Implementation_AdjacencyList {

    // Edge class to represent a connection between two nodes (vertices)
    static class Edge {
        int src;   // Source vertex of the edge
        int dest;  // Destination vertex of the edge

        // Constructor to initialize an edge from src to dest
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Method to initialize the graph with lists for each vertex
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize list for each vertex in the graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges to the graph to represent an undirected graph
        // In an undirected graph, if there's an edge from u to v, there's also an edge from v to u
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        // Note: The edge (2, 2) has been removed assuming no self-loops are needed in the undirected graph
    }

    // Main method to execute the graph implementation
    public static void main(String[] args) {
        int V = 4;  // Number of vertices in the graph

        // The graph is an array where each element is a list that represents a vertex and its edges
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph); // Populate the graph with edges

        // Printing the adjacency list for each vertex
        for (int i = 0; i < graph.length; i++) {
            // Check if the vertex has any edges
            if (graph[i].size() > 0) {
                // For each edge, print the source and destination vertices
                for (Edge edge : graph[i]) {
                    System.out.println("Edge from " + edge.src + " to " + edge.dest);
                }
            }
        }
    }
}
