package Strings;



public class Longest_Palindrome_Substring {

    // time complexity - O(n^2)
    public  String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for(int i=0;i<s.length();i++){
            int len1= expandfrommiddle(s,i,i); // if odd length string like 'racecar'
            int len2= expandfrommiddle(s,i,i+1); // if even length string like 'aabbaa'
            int len= Math.max(len1,len2);

            if(len>end - start){
                start= i- ((len-1)/2);
                end= i+(len/2);
            }
        }

        return s.substring(start,end+1);

    }

    public int expandfrommiddle(String s , int left , int right){
        if(s==null || left>right )
            return 0;

        while(left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }

    public String longestpalindrome_dp (String s ){

        if(s==null || s.length()<2){
            return s;
        }

        boolean[][] ispalindrome= new boolean[s.length()][s.length()];
        int max=0; int left=0; int right=1;

        for(int i=s.length()-1;i>=0;i--){
            for( int j=i;j<s.length();j++){
                if(i==j){
                    ispalindrome[i][j]=true;
                }
                else if (s.charAt(i)==s.charAt(j)){
                    if(j-i==1){
                        ispalindrome[i][j]=true;
                    }
                    else{
                        ispalindrome[i][j]= ispalindrome[i+1][j-1];
                    }
                }

                if (ispalindrome[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    left = i;
                    right = j + 1;
                }
            }



        }

        return s.substring(left,right);
    }

   /*

   Brute Force Method - O(n^3)

   public static  String longestPalindrome(String s) {

        StringBuilder ans = new StringBuilder();

        for(int i=0;i<s.length();i++){
        for(int j=i+1;j<s.length();j++) {
            if (s.charAt(j) == s.charAt(i)) {
                if (ispalindrome(s.substring(i, j + 1)) == true) {
                   StringBuilder temp = new StringBuilder();
                    temp.append(s.substring(i, j + 1));
                    if (temp.length() > ans.length()) {
                        ans = temp;
                    }
                }

            }

        }

        }

        if(ans.toString()==""){
            ans.append(s.charAt(0));
            return ans.toString();
        }
        else{
            return ans.toString();
        }
    }

    public static boolean ispalindrome(String s ){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
*/
    public static void main(String[] args) {
        Longest_Palindrome_Substring longestPalindromeSubstring= new Longest_Palindrome_Substring();
        String ans= longestPalindromeSubstring.longestpalindrome_dp("anudeepbilla");
        System.out.println(ans);

    }


}
