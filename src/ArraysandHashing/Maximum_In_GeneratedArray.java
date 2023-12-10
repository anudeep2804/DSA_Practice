package ArraysandHashing;

import java.util.ArrayList;
import java.util.Arrays;

public class Maximum_In_GeneratedArray {

    public int getMaximumGenerated(int n){

        if( n==0) return 0;

        int[] nums = new int[n+1];

        nums[0]=0;
        nums[1]=1;

        int maximum =1;

        for(int i=2;i<n+1;i++){
            if(i%2==0){
                nums[i]= nums[i/2];
            }
            else{
                nums[i]=nums[i/2]+nums[i/2 + 1];
            }

            maximum = Math.max(maximum,nums[i]);
        }

        return maximum;
    }
}
