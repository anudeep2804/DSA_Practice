package Recursion;

// https://leetcode.com/problems/permutations-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        backtrack ( result , new ArrayList<Integer>(), nums , new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> templist, int[] nums, boolean[] used) {

        // if we match the length it is a permutation

        if(templist.size() == nums.length && !result.contains(templist)){

                List<Integer> temp = new ArrayList<>(templist);
                result.add(temp);
                return;
            }

            for(int i=0 ; i<nums.length ;i++){

                if(used[i]) continue;  // skip if we got the same element

                // add new element and mark it used
                used[i]=true;
                templist.add(nums[i]);

                // go back and try another element

                backtrack(result, templist , nums , used);

                //remove the element and mark it unused

                used[i]=false;


                templist.remove(templist.size()-1);
            }
        }

}
