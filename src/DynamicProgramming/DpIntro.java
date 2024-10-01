package DynamicProgramming;

/**
 * Approach one : Memomization ( store the values of your call stack to avoid recomputation)
 * Step 1 : Identify the recursion sub-problem , initialize and data structure to store values
 * Step 2 : perform the recursion step check if its already computed if yes return else continue
 */

import java.util.Arrays;

/**
 * Approach tow : Tabulation ( Iterative approach )
 * Iteratively solve the subproblems, starting from the smallest and working up.
 * Use a table (like an array) to store the solutions for the subproblems.
 * The final result is the value in the last cell of the table.
 */

public class DpIntro {

    public static void main(String[] args) {
        System.out.println(memoization(4));
        System.out.println(tabulation(3));
    }

   static int memoization ( int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return memoHelper(n, dp);
    }

   static  int tabulation(int n){

        if(n<=1) return  n;

        int[] dp = new int[n+1];

        dp[0]=0; dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

   static int memoHelper(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = memoHelper(n-1, dp) + memoHelper(n-2, dp);

        return dp[n];
    }
}
