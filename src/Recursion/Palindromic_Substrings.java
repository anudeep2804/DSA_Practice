package Recursion;

public class Palindromic_Substrings {


    public int countSubstrings(String s) {

        int count=0;

        for(int i=0; i<s.length();i++){

            helper(i,s.length(),s, count);
        }

        return count;
    }

    private void helper(int i, int length, String s, int count) {

        if(i==length-1){
            return;
        }

        if(Checkpalindrome(s.substring(i , length))==true){
            count= count+1;
        }

         helper(i+1, length , s, count);
    }

    private boolean Checkpalindrome(String substring) {

        int i=0; int j=substring.length()-1;

        while (i<j){
            if(substring.charAt(i)!=substring.charAt(j)){
                return false;
            }

            i++; j++;
        }

        return true;
    }


}
