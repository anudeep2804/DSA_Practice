package Graphs.topologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Find_Eventual_SafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> safe_nodes = new ArrayList<>();


        boolean[] visited = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(graph[i].length < 1){
                safe_nodes.add(i);
                visited[i]=true;
            }
        }

        for(int i=0; i<graph.length; i++) {
            if(!visited[i]){
                dfs(i, graph, visited, safe_nodes);
            }
        }

        Collections.sort(safe_nodes);

        return safe_nodes;
    }

    private boolean dfs(int i, int[][] graph, boolean[] visited, List<Integer> safeNodes) {
        if (visited[i]) {
            return safeNodes.contains(i);  // Return true only if it's a known safe node
        }

        visited[i] = true;

        for (int it : graph[i]) {
            if (!dfs(it, graph, visited, safeNodes)) {
                return false;
            }
        }

        safeNodes.add(i);
        return true;
    }
}
