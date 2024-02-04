package Heaps_PriorityQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

    public int[][] highFive(int[][] items) {

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int[] item : items){
            int key = item[0];
            int currentscore = -1 * item[1];

            if(map.get(key)!=null){
                PriorityQueue<Integer> curr_pq = map.get(key);
                curr_pq.add(currentscore);
                map.put(key , curr_pq);
            }
            else {
                PriorityQueue<Integer> temp = new PriorityQueue<>();
                temp.add(currentscore);
                map.put(key, temp);
            }
        }

        int[][] result = new int[map.size()][2];
        int i=0;

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int arr[] = new int[2];
            arr[0]=entry.getKey();
            arr[1]= (int)getavg(entry.getValue());
            result[i] = arr;
            i++;
        }

        return result;
    }


    double getavg(PriorityQueue<Integer> pq){

        int sum=0;

        for(int i=0; i<5; i++){
            sum = sum - pq.poll();
        }

        return sum/5;
    }
}
