package ArraysandHashing;

import java.util.HashMap;

public class ContainsDuplicateII {


        public boolean containsNearbyDuplicate(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    if (Math.abs(map.get(nums[i]) - i )<= k) {
                        //System.out.println(map.get(nums[i])+"/"+i);
                        return true;
                    }
                }

                map.put(nums[i], i);
            }

            return false;

        }
}
