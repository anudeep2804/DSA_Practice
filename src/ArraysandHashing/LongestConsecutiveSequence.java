package ArraysandHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        if(nums.length==1){
            return 1;
        }

        if(nums.length==0){
            return 0;
        }

        HashMap<Integer,Integer> hashMap= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }


        int longestseq=1;

        for(int i=0;i< nums.length;i++){
            int counter=1;
            int currentvalue=nums[i];


            while((hashMap.containsKey(currentvalue+1))==true){
                counter++;

                currentvalue=currentvalue+1;
            }

            if(counter>longestseq){
                longestseq=counter;
            }
        }


        return longestseq;

        /*
        Optimal answer



    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int ans = 1;
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }


         */

    }

    public static void main(String[] args) {
        int[] input={0,0,0,0};
        int ans= longestConsecutive(input);
        System.out.println(ans);
    }
}
