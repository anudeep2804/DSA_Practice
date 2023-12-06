package ArraysandHashing;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int n : nums){
            priorityQueue.offer(n);

            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

//        int i=0;
//
//        while(i< nums.length-k){
//            priorityQueue.poll();
//            i++;
//        }

        return  priorityQueue.peek();
    }

}
