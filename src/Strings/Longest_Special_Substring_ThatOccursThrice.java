package Strings;

import java.util.HashMap;
import java.util.Map;

public class Longest_Special_Substring_ThatOccursThrice {

    /*
    Q: https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/

    Approach :

    Save all the substrings, and it's counted in HashMap
    Iterate through all the strings in the map
    Check string contains the same characters and occurrences more than 3 times
     Take the longest string as an answer
     */

    public int maximumLength(String s) {
        int res = -1;

        char[] arr = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                String curr = s.substring(i, j+1);
                map.put(curr, map.getOrDefault(curr, 0)+1);
            }
        }

        for(String str : map.keySet()){
            if(map.get(str) >= 3){
                boolean flag = true;

                char ch = str.charAt(0);
                for(int i=1; i<str.length()&&flag; i++){
                    if(str.charAt(i) != ch) flag = false;
                }
                if(flag) res = Math.max(res, str.length());
            }
        }

        return res;
    }

}
