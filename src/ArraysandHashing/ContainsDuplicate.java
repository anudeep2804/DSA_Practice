package ArraysandHashing;

import java.util.HashMap;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){

        if(nums.length<1){
            return true;
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            if(hashMap.containsKey(nums[i])){

                return true;
            }
            else{
                hashMap.put(nums[i],1 );
            }
        }

        return false;
    }
}
