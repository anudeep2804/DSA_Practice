package Graphs;

import java.util.ArrayList;

public class DetectCycle_UndirectedGraph_DFS {


    static boolean checkForCycle(int V , ArrayList<ArrayList<Integer>> adj){

        boolean[] visited = new boolean[V];


        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited , -1)) return true;
            }
        }

        return false;


    }

    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {

          visited[v] =true;

          for(Integer neighbor : adj.get(v)){
              if(!visited[neighbor]) {
                  if (dfs(neighbor, adj, visited, v))
                      return true;
              }

              else if (parent!=neighbor){
                  return true;
              }
          }

          return false;

    }


}
