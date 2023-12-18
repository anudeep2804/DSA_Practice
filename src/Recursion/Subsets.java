package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        result.add(temp);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < result.size(); j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }

        }

        return result;
    }

    public List<List<Integer>> subsetsrecursion(int[] nums) {
        // Initialize the list to store all subsets
        List<List<Integer>> ans = new ArrayList<>();

        // Add an empty subset to the list
        ans.add(new ArrayList<>());

        // Call the helper function to generate all subsets
        helper(ans, nums);

        return ans;
    }

    private List<List<Integer>> helper(List<List<Integer>> ans, int[] nums) {
        // Base case: if nums is empty, return null as there are no more elements to process
        if (nums.length == 0) {
            return null;
        }

        // Calculate the current size of the answer list
        int n = ans.size();

        // Iterate over all subsets generated so far
        for (int i = 0; i < n; i++) {
            // Create a new list by copying the current subset
            List<Integer> list = new ArrayList<>(ans.get(i));

            // Add the first element of nums to this new subset
            list.add(nums[0]);

            // Add the new subset to the answer list
            ans.add(list);
        }

        // Recursive call: process the remaining elements (excluding the first element)
        // Here is the key concept of backtracking:
        // We explore each subset by adding the current element and then
        // move on to the next element. Once all subsets containing the current
        // element are explored, the function backtracks to explore subsets without
        // the current element.
        return helper(ans, Arrays.copyOfRange(nums, 1, nums.length));
    }
}
