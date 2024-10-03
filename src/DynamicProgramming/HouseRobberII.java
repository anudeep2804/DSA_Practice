package DynamicProgramming;

import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        if(n==2) return Math.max(nums[0], nums[1]);

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(MemoHelper(nums, n-1, dp1), MemoHelper1(nums, n-2, dp2));

    }
    static int MemoHelper(int[] nums, int n, int[] dp){

        if(n<1) return 0;

        if(n==1) return nums[1];

        if(dp[n] != -1) return dp[n];

        int pick = nums[n] + MemoHelper(nums, n-2, dp);
        int notpick = MemoHelper(nums, n-1, dp);

        return dp[n] = Math.max(pick, notpick);

    }

    static int MemoHelper1(int[] nums, int n, int[] dp){

        if(n<0) return 0;

        if(n==0) return nums[0];

        if(dp[n] != -1) return dp[n];

        int pick = nums[n] + MemoHelper1(nums, n-2, dp);
        int notpick = MemoHelper1(nums, n-1, dp);

        return dp[n] = Math.max(pick, notpick);

    }
}
