package Graphs;

import java.util.HashSet;

class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        if(graph == null) return false;
        int n = graph.length;

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        boolean[] visited = new boolean[n];
        boolean[] result = {true}; // Use an array to hold the result

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                setA.add(i);
                helper(i, setA, setB, graph, visited, result);
                if (!result[0]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void helper(int i, HashSet<Integer> setA, HashSet<Integer> setB, int[][] graph, boolean[] visited, boolean[] result) {
        if (!result[0]) return; // Early termination if we've already found it's not bipartite
        visited[i] = true;

        for (int val : graph[i]) {
            if (setA.contains(i)) {
                if (setA.contains(val)) {
                    result[0] = false;
                    return;
                }
                if (!visited[val]) {
                    setB.add(val);
                    helper(val, setA, setB, graph, visited, result);
                }
            } else if (setB.contains(i)) {
                if (setB.contains(val)) {
                    result[0] = false;
                    return;
                }
                if (!visited[val]) {
                    setA.add(val);
                    helper(val, setA, setB, graph, visited, result);
                }
            }
        }
    }
}