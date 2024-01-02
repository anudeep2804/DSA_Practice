package ArraysandHashing;

import java.util.ArrayList;
import java.util.List;

public class ConvertArray_to_2DArray {

    // https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/?envType=daily-question&envId=2024-01-02

    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentlist = new ArrayList<>();

        currentlist.add(nums[0]);

        result.add(currentlist);

        for(int i=1; i<nums.length;i++){

            boolean inserted=false;

            int size = result.size();

            for(int j=0 ; j<size;j++){
                if(!result.get(j).contains(nums[i])){
                    result.get(j).add(nums[i]);
                    inserted=true;
                    break;
                } else {
                    continue;
                }
            }

            if(!inserted){
                List<Integer> templist = new ArrayList<>();
                templist.add(nums[i]);
                result.add(templist);
            }
        }

        return result;

    }
}
