package ArraysandHashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DifferenceofTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        // 1. Simplified addition to HashSet
        HashSet<Integer> hashSetnum1 = new HashSet<>();
        for(int i: nums1){
            hashSetnum1.add(i);
        }

        HashSet<Integer> hashSetnum2 = new HashSet<>();
        for(int i: nums2){
            hashSetnum2.add(i);
        }

        // 2. Use a copy of hashSetnum1 for removing elements
        HashSet<Integer> temp = new HashSet<>(hashSetnum1);

        hashSetnum1.removeAll(hashSetnum2);
        hashSetnum2.removeAll(temp);

        // 3. Directly add to the answer list
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(hashSetnum1));
        ans.add(new ArrayList<>(hashSetnum2));

        return ans;
    }

}
