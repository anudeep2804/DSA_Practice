package Twopointers;

public class ValidPalindrome {

    public  static boolean isPalindrome(String s) {

        if(s.length()<=1){
            return true;
        }

        String ans=converttoalphanumeric(s);
        int i=0;
        int j=ans.length()-1;

        boolean ispalindrome=true;

        while (i<j && ispalindrome==true){

            if(ans.charAt(i)!=ans.charAt(j)){
                ispalindrome=false;
                break;
            }
             i++;
            j--;
        }

        return ispalindrome;
    }

    public static String converttoalphanumeric(String s) {

        String temp = s.toLowerCase();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {
            if (Character.isDigit(temp.charAt(i)) || Character.isAlphabetic(temp.charAt(i))) {
                str.append(temp.charAt(i));
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String str="";
        boolean  ans = isPalindrome(str);
        System.out.print(ans);
    }
}
