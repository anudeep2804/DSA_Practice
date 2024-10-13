package DynamicProgramming.DpSubsets;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int i : nums){
            sum = sum + i;
        }

        Boolean [][] dp = new Boolean [nums.length][sum / 2  + 1];

        if(sum % 2 != 0) return false;

        return memoHelper(nums, dp, 0, sum, 0);
    }

    boolean memoHelper(int[] nums , Boolean[][] dp , int i, int sum, int currentSum ){

        if(currentSum == sum / 2 ){
            return true;
        }

        if( i > nums.length -1) {
            return false;
        }

        if (currentSum > sum / 2) {
            return false;
        }

        if (dp[i][currentSum] != null) {
            return dp[i][currentSum];
        }


        dp[i][currentSum] = memoHelper(nums, dp, i+1, sum, currentSum + nums[i]) || memoHelper(nums,dp, i+1,sum , currentSum);

        return dp[i][currentSum];
    }
}
