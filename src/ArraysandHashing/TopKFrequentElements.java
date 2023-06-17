package ArraysandHashing;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) throws  ArrayIndexOutOfBoundsException {
    /* brute force idea

    Frequency hashamp of array will be given and all values in hashmap will be put into arraylist
    reversesort the arraylist and run loop for given k and for each value of arraylist element in loop
    retrive corresponding key value , add it to new array and return

    Mistakes & Drawbacks :

    Fails for cases where same value has more than one keys
    computationally costly
     */

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencymap = new HashMap<>();
        for (int n : nums) {
            frequencymap.put(n, frequencymap.getOrDefault(n, 0) + 1);

        }

        for( int key : frequencymap.keySet()){
            int frequencyvalue= frequencymap.get(key);
            if(bucket[frequencyvalue]==null){
                bucket[frequencyvalue]=new ArrayList<>();
            }

            bucket[frequencyvalue].add(key);
        }

        int res[] = new int[k];

        int counter=0;



        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (Integer integer : bucket[pos]) {
                    res[counter++] = integer;
                }
            }
        }
        return res;
    }

    /* O(nlogn) solution :

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
            while (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
     */

    public static void main(String[] args) {
        int input[] = {1,1,1,1,2,2,2,2,3};
        int ans[] = topKFrequent(input,1);
        System.out.println(Arrays.toString(ans));
    }
}
