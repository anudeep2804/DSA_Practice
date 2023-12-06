package Heaps_PriorityQueues;

import java.util.Collections;
import java.util.PriorityQueue;

public class Last_Stone_Weight  {

    public int lastStoneWeight(int[] stones) {
        // Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Process the stones
        while (maxHeap.size() > 1) {
            int heaviestStone = maxHeap.poll();
            int secondHeaviestStone = maxHeap.poll();

            if (heaviestStone != secondHeaviestStone) {
                maxHeap.offer(heaviestStone - secondHeaviestStone);
            }
        }

        // Check if there is a stone left and return its weight, otherwise return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

}
