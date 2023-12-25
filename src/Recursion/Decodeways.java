package Recursion;

public class Decodeways {

    // optimal way to solve these kind of problems would be Dynamic Programming

    public int numDecodings(String s) {

        return decoderecursive(s,0);
    }

    int decoderecursive( String s , int index){

        if(index==s.length()) return 1;  // this is valid decoding

        if(s.charAt(index)==0) return 0; // if single element 0 is considered it does not add any valid strings , or
        // even if considered with other number like 06 , its still invalid

        int ways = decoderecursive(s, index+1); // possible ways for decoding single digit

        // decode two digits if possible

        if(index+1 <s.length() && Integer.parseInt(s.substring(index, index+2)) <=26){
            ways= ways+ decoderecursive(s, index+2);
        }

        return ways;

    }
}
