package ArraysandHashing;

import java.util.HashMap;
import java.util.Map;

public class Majority_element {


    // Moore's Voting Algorithm , Question : https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150


    public  static int majorityElement(int[] nums) {

        int result = nums[0];

        int count =1;

        for( int i=1 ; i< nums.length; i++) {

            if(count==0){
                result = nums[i];
            }

            if(nums[i]==result) {
                count++;
            }
            else{
                count--;
            }


        }

        return result;
    }

    /*

    Initial Intution Approach : HashMap

    public int majorityElement(int[] nums) {

        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length/2){
                result=entry.getKey();
            }
        }



        return result;
    }
    */

    public static void main(String[] args) {
        int nums[] = {1,2,1,3,1,1};
        System.out.println(majorityElement(nums));
    }

}
