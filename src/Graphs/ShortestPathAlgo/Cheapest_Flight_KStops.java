package Graphs.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Cheapest_Flights_KStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<FlightNode>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int[] cost = new int[n];
        int[] stops = new int[n];

        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);

        cost[src] = 0;
        stops[src] = 0;

        for(int[] a : flights){
            int source = a[0];
            int destination = a[1];
            int price = a[2];
            adj.get(source).add(new FlightNode(destination, price, 0));
        }

        PriorityQueue<FlightNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.price, b.price));

        pq.add(new FlightNode(src, 0, 0));

        while (!pq.isEmpty()) {
            FlightNode currentnode = pq.poll();
            int current_place = currentnode.dest;
            int current_price = currentnode.price;
            int current_stops = currentnode.stops;

            if (current_place == dst) {
                return current_price;
            }

            if (current_stops > k) {
                continue;
            }

            for (FlightNode node : adj.get(current_place)) {
                int new_dest = node.dest;
                int new_price = current_price + node.price;
                int new_stops = current_stops + 1;

                if (new_price < cost[new_dest] || new_stops < stops[new_dest]) {
                    cost[new_dest] = new_price;
                    stops[new_dest] = new_stops;
                    pq.add(new FlightNode(new_dest, new_price, new_stops));
                }
            }
        }

        return -1;
    }
}

class FlightNode {
    int dest;
    int price;
    int stops;

    public FlightNode(int dest, int price, int stops) {
        this.dest = dest;
        this.price = price;
        this.stops = stops;
    }
}
