import java.util.HashMap;
import java.util.Map;

public class Min_Ops_toMake_ArrayEmpty {

    public int minOperations(int[] nums) {

        int result=0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            int currentval=entry.getValue();
            if(currentval==1){
                return -1;
            }

            result +=  currentval/3;

            if(currentval % 3 !=0){
                result=result+1;
            }
        }

        return result;
    }
}
