package ArraysandHashing;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int[] nums){

        int result = Integer.MIN_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                result= entry.getKey();

                break;
            }
        }

        return  result;
    }
}
