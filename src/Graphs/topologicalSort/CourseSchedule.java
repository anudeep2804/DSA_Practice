package Graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {


    // Implementation using Kahn's algorithm

    public boolean canFinish(int n, int[][] prerequisites) {

           int[] indegree = new int[n];
           List<Integer>[] adj = new List[n];
           List<Integer> topo = new ArrayList<>();

           for(int[] pair : prerequisites){
               int current_course = pair[0];
               int prereq = pair[1];

               if(adj[prereq] == null){
                   adj[prereq] = new ArrayList<>();
               }

               adj[prereq].add(current_course);
               indegree[current_course]++;
           }

        Queue<Integer> queue = new LinkedList<>();

           for(int i=0; i< indegree.length; i++){
               if(indegree[i]==0) queue.offer(i);
           }

           while (!queue.isEmpty()){
               int current = queue.poll();
               topo.add(current);

               if(adj[current]!=null){
                   for(int it : adj[current]){
                       indegree[it]--;
                       if(indegree[it]==0){
                           queue.offer(it);
                       }
                   }
               }
           }

           return topo.size() == n;
    }
}
