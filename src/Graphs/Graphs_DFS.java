package Graphs;

import java.util.ArrayList;

public class Graphs_DFS {


    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {


        if( V <=0 || adj.size()<=0){
            return new ArrayList<>();
        }

        ArrayList<Integer> graph_dfs_list = new ArrayList<>();

        boolean visited[] = new boolean[V];

        helper(0 , adj , graph_dfs_list , visited);

        return graph_dfs_list;
        // Code here
    }

    private void helper(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> graphDfsList , boolean[] visited) {

        graphDfsList.add(i);
        visited[i]=true;


        if(adj.get(i).size() >0){

            for(Integer element : adj.get(i)){
                if(!visited[element]){
                    helper(element , adj, graphDfsList, visited);
                }
                else {
                    continue;
                }
            }

        }
    }
}
