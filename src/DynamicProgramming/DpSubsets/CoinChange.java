package DynamicProgramming.DpSubsets;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];

        for( int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return minimumElementsUtil(coins, coins.length -1 , amount, dp);
    }

    int Tabl (int[] coins, int amount){
        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0]=0;

        for(int coin : coins){
            for(int j=coin; j<=amount; j++){
                if(dp[j-coin] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j-coin]+1);
            }
        }

        if(dp[amount] == Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

    int minimumElementsUtil(int[] arr, int ind, int T, int[][] dp) {
        // Base case: If the current index is 0
        if (ind == 0) {
            // If T is divisible by the first element of the array, return the quotient
            if (T % arr[0] == 0)
                return T / arr[0];
            else
                // If not, return a large value to indicate it's not possible
                return (int) Math.pow(10, 9);
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1)
            return dp[ind][T];

        // Calculate the minimum number of elements needed without taking the current element
        int notTaken = minimumElementsUtil(arr, ind - 1, T, dp);

        // Initialize the minimum number of elements needed taking the current element
        int taken = (int) Math.pow(10, 9);

        // If the current element is less than or equal to T, calculate the minimum taking it
        if (arr[ind] <= T)
            taken = 1 + minimumElementsUtil(arr, ind, T - arr[ind], dp);

        // Store the minimum result in the dp array and return it
        return dp[ind][T] = Math.min(notTaken, taken);
    }
}
