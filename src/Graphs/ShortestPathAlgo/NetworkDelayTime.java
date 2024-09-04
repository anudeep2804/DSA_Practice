package Graphs.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null) return -1;

        // Initialize distances to infinity, except the start node `k`
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Create an adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate an adjacency list with edges
        for (int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int travelTime = time[2];
            adj.get(src).add(new Node(dest, travelTime));
        }

        // Priority Queue to process nodes based on the shortest time
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Node(k, 0));

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currNode = current.dest;
            int currTime = current.time;

            // If we find a longer time than the recorded one, skip processing
            if (currTime > dist[currNode]) continue;

            // Relaxation step
            for (Node neighbor : adj.get(currNode)) {
                int newTime = currTime + neighbor.time;
                if (newTime < dist[neighbor.dest]) {
                    dist[neighbor.dest] = newTime;
                    pq.add(new Node(neighbor.dest, newTime));
                }
            }
        }

        // Calculate the maximum time it took to reach any node
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Some nodes are unreachable
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}

class Node {
    int dest;
    int time;

    public Node(int dest, int time) {
        this.dest = dest;
        this.time = time;
    }
}
