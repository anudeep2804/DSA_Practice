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

    public List<List<Integer>> subsetsrecursion ( int [] nums ){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

         helper(ans , nums);

         return  ans;
    }

    private List<List<Integer>>  helper(List<List<Integer>> ans, int[] nums) {

        if(nums.length==0){
            return null;
        }
         int n = ans.size();
        for( int i=0; i<n ;i++){
            List<Integer> list  = new ArrayList<>(ans.get(i));
            list.add(nums[0]);
            ans.add(list);
        }

        return helper(ans , Arrays.copyOfRange(nums , 1 , nums.length-1));
    }
}
