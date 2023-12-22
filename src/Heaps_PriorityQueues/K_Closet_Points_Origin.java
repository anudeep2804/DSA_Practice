package Heaps_PriorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Closet_Points_Origin {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> calculatedist(b)- calculatedist(a));

        for(int[] point : points) {
            priorityQueue.add(point);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

            int[][] result = new int[k][];
            int i=0;

            while(!priorityQueue.isEmpty()){
                result[i++] = priorityQueue.poll();
            }

  return result;

    }

    public int calculatedist (int[] arr){
        return (int) (Math.pow(arr[0],2)+ Math.pow(arr[1],2));
    }
}
