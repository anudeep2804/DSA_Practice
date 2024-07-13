package Graphs;


import java.util.ArrayList;
import java.util.List;

/**
 * Idea is to have a helper array to see in a give path if cycle exists
 * so for the helper arrau if already a node is visisted then cycle exists
 * 
 */

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean visited[] = new boolean[prerequisites.length];
        boolean helper[] = new boolean[prerequisites.length];
        
        // Create an adjancency list 

        List<List<Integer>> adjaceny_list = new ArrayList<>();
        
        for(int i=0; i< prerequisites.length; i++){
            
            List<Integer> temp = new ArrayList<>();
            
            adjaceny_list.add(i , temp);
        }
        
        for(int[] pre : prerequisites){
            adjaceny_list.get(pre[0]).add(pre[1]);
        }
        
        // traverse all the given courses in the given array and check if cycle exists at any place 
        
        for(int i=0; i<prerequisites.length ; i++){
            
            if(!visited[i]){
                boolean ans = dfs_cycleDetection(adjaceny_list, i, visited , helper);
                if(ans) return false;
            }
        }


return true;

    }

    private boolean dfs_cycleDetection(List<List<Integer>> adjacenyList, int i, boolean[] visited, boolean[] helper) {

        visited[i]= true;
        helper[i] = true;

        List<Integer> neighbour = adjacenyList.get(i);

        for (int curr : neighbour) {

            // if the same element is already visited then we found a cycle
            if (helper[curr]) return true;

            if (!visited[curr]) {
                boolean ans = dfs_cycleDetection(adjacenyList, curr, visited, helper);
                if (ans) return true;
            }
        }

        // backtrack and set the helper of current node to false

        helper[i] = false;
        return  false;
    }
}
