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
}
