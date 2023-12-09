package Heaps_PriorityQueues;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class TaskScheduler {



    public int leastInterval(char[] tasks, int n) {

        if (tasks == null) {
            return -1;
        }

        if (n == 0) {
            return tasks.length;
        }

        int[] char_map = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            char_map[tasks[i] - 'A']++;
        }

        Arrays.sort(char_map);

        int max_val = char_map[25] - 1;

        int idle_slots = max_val * n;

        for (int i = 24; i >= 0; i--) {
            idle_slots -= Math.min(char_map[i], max_val);
        }

        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;


    }
        /*


     Heap based solution

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;
        for (int val : arr) if (val > 0) pq.add(val);
        int time = 0;

        while ((!pq.isEmpty() || !q.isEmpty())) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val > 0) q.add(new Pair(val, time + n));
            }

            if (!q.isEmpty() && q.peek().getValue() == time) pq.add(
                q.poll().getKey()
            );
        }
        return time;
    }


         */



}
