package DynamicProgramming;

import java.sql.Statement;
import java.util.Arrays;

public class HouseRobber {

    public static  int MaxProfit(int[] nums){

        return MaxProfit_Tabularization(nums);
    }

    int MaxProfit_Memo(int[] nums){

        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return MemoHelper(nums, n-1, dp);

    }
    static int MemoHelper(int[] nums, int n, int[] dp){

        if(n<0) return 0;

        if(n==0) return nums[0];

        if(dp[n] != -1) return dp[n];

        int pick = nums[n] + MemoHelper(nums, n-2, dp);
        int notpick = MemoHelper(nums, n-1, dp);

       return dp[n] = Math.max(pick, notpick);

    }

   static  int MaxProfit_Tabularization(int[] nums){

        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp = new int[n];

        dp[0]=nums[0]; dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }

        return dp[n -1];
    }
}
