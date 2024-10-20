package DynamicProgramming.Subsequences;

public class Min_Insertions_Palindrome {

    // Length of String minus the length of longest palindromic subseq will give you extra char's which is equivalent to min additions

    public int minInsertions(String s) {

        int lps = Tabl(s, new StringBuilder(s).reverse().toString(), s.length(), s.length());

        return s.length() - lps;
    }

    int Tabl(String text1, String text2, int n1, int n2){

        int[][] dp = new int[n1+1][n2+1];

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n1][n2];
    }


}
