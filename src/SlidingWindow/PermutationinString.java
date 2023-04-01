package SlidingWindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PermutationinString {

    public static boolean checkInclusion(String s1, String s2) {
        boolean IsSubset = false;

        if(s2.length()<s1.length()){
            return IsSubset;}
        if(s1.length()==0)
            return !IsSubset;

        int s1array[] = new int[26];
        int s2array[]=new int[26];

        for(int i=0;i< s1.length();i++){
            s1array[s1.charAt(i)-'a']++;
            s2array[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(s1array,s2array)){
            return !IsSubset;
        }

        for(int i=s1.length();i<s2.length();i++){



            s2array[s2.charAt(i-s1.length())-'a']--;
            s2array[s2.charAt(i)-'a']++;
            if(Arrays.equals(s1array,s2array)){
                return !IsSubset;
            }
        }

        return IsSubset;

    }


    public static void main(String[] args) {
        String s1="ab";
        String s2="ab";

        System.out.println(checkInclusion(s1,s2));
    }
}
