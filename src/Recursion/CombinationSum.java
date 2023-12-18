package Recursion;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Initialize the list that will hold all the unique combinations
        List<List<Integer>> list = new ArrayList<>();

        // Sort the array. This step is not necessary for the algorithm to function
        // correctly, but it can help improve performance and the order of results.
        Arrays.sort(nums);

        // Start the backtracking algorithm
        backtrack(list, new ArrayList<>(), nums, target, 0);

        // Return the list of combinations
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        // If the remaining sum is negative, there's no point in continuing
        // as we cannot reach the target.
        if(remain < 0) return;

            // If the remaining sum is exactly 0, we have found a valid combination.
            // Add a copy of it to our list of combinations.
        else if(remain == 0) list.add(new ArrayList<>(tempList));

            // If the remaining sum is positive, continue exploring further.
        else {
            // Iterate through the array, starting from the 'start' index.
            for(int i = start; i < nums.length; i++){
                // Add the number at the current index to the temporary list.
                tempList.add(nums[i]);

                // Recursively call the backtrack function with the updated list and
                // the remaining sum decreased by the number just added.
                // The 'start' remains 'i' because we can reuse the same element.
                System.out.println(tempList);
                backtrack(list, tempList, nums, remain - nums[i], i);

                // Backtrack: remove the last number added, so we can try
                // the next number in the next iteration of the for-loop.
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();

        List<List<Integer>> ans = combinationSum.combinationSum(new int[] {1,2,3 } , 4);

        System.out.println(ans);
    }

}
