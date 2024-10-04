package DynamicProgramming;

/**
 * Approach one : Memomization ( top down)
 * Step 1 : express the recusrsion subproblem in terms of index
 * Step 2: relate the recurrence relation in terms of index and perform required action
 * Step 3: store the cal value , for given index if dp array already has a value return that value instead of doing recursion again
 */

import java.util.Arrays;

/**
 * Approach tow : Tabulation ( Iterative approach , Bottom up )
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
