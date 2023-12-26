package Recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SubSetsII {

    // https://leetcode.com/problems/subsets-ii/

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        backtrack2(resultList , new ArrayList<>() , nums , 0);

        return resultList;


    }

    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack2(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    private void backtrack(List<List<Integer>> resultset, List<Integer> tempset, int[] nums, int start) {

    if(resultset.contains(tempset))
        return;

    resultset.add(new ArrayList<>(tempset));

    for( int i= start; i< nums.length ; i++){
        tempset.add(nums[i]);

        backtrack(resultset, tempset, nums, i+1);

        tempset.remove(tempset.size() -1);

    }

    }

    // iterative method

    public List<List<Integer>> subsetsii(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        result.add(temp);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < result.size(); j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                if(result.contains(list)) continue;
                else result.add(list);
            }

        }

        return result;
    }

}
