package ArraysandHashing;

import java.util.Arrays;

public class ProdofArrayExceptSelf {

    public  static int[] productExceptSelf(int[] nums) {
        /* Brute force
        int[] res = new int[nums.length];

        int pointer=0;
        int leftprod=1;
        int rightprod=1;

        while(pointer< nums.length){
            leftprod=1;
            rightprod=1;
            for(int i=0;i<pointer;i++){

                leftprod=leftprod*nums[i];
            }
            for(int j=pointer+1;j< nums.length;j++){

                rightprod=rightprod*nums[j];
            }

            res[pointer]=leftprod*rightprod;
            pointer++;
        }



        return res;

         */

        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        int input[]={-1,1,0,-3,3};
        int[] ans= productExceptSelf(input);
        System.out.println(Arrays.toString(ans));
    }
}
