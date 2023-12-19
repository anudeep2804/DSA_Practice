package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permuntations {


    // https://leetcode.com/problems/permutations/description/


    /*
    Iterate over each charecter
    for each character :
        - start to pick the 1st character
        - go back
         - try picking next
     */

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        backtrack (new ArrayList<Integer>() , nums);

        return result;

    }


    private void backtrack(ArrayList<Integer> templist, int[] nums) {

        if(templist.size()== nums.length){
            List<Integer> temp = new ArrayList<>(templist);
            result.add(temp);
            return;
        }

        for( int num : nums){

            if(templist.contains(num)){
                continue;
            }

            // add new element
            templist.add(num);

            // go back and try other element
            backtrack(templist, nums);

            // remove the element

            templist.remove(templist.size()-1);
        }
    }
}
