package DynamicProgramming.Subsequences;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

         int n1 = text1.length();
         int n2 = text2.length();

         int[][] dp = new int[n1][n2];

         for(int[] arr : dp){
             Arrays.fill(arr, -1);
         }

         return memo(n1-1, n2-1, text1, text2, dp);
    }

    private int memo( int index1, int index2, String text1, String text2, int[][] dp) {

        if(index1 <0 || index2 < 0){
            return 0;
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        if(text1.charAt(index1) == text2.charAt(index2)){
            return dp[index1][index2] = 1+ memo(index1-1, index2-1, text1, text2, dp);
        }

        else {

            int text1Match = memo( index1-1, index2, text1, text2, dp);
            int text2Match = memo(index1, index2-1, text1, text2, dp);

            return  dp[index1][index2] =  Math.max( text1Match, text2Match);
        }
    }
}
