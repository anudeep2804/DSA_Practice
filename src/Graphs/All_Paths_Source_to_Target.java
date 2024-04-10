package Graphs;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_Source_to_Target {

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> result = new ArrayList<>();
            if (graph.length < 1) {
                return result;
            }

            helper(0, graph.length - 1, graph, new ArrayList<>(List.of(0)), result);
            return result;
        }

        private void helper(int i, int n, int[][] graph, ArrayList<Integer> current_list, List<List<Integer>> result) {
            // Base case: if the current node is the target node, add the current path to the result
            if (i == n) {
                result.add(new ArrayList<>(current_list));
                return;
            }

            // Explore all possible next nodes
            for (int element : graph[i]) {
                // Add the next node to the current path
                current_list.add(element);
                // Recurse with the new path
                helper(element, n, graph, current_list, result);
                // Backtrack: remove the last element added
                current_list.remove(current_list.size() - 1);
            }
        }



}
