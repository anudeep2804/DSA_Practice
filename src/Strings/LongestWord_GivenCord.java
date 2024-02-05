package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWord_GivenCord {

   static List<String> getLongestString(List<String> list, String input){
       List<String> result = new ArrayList<>();

       int[] bucket = new int[26];

       for(char ch : input.toCharArray()){
           bucket[ch-'a']= bucket[ch-'a']+1;
       }

       int maxlen=0;

       for(String str : list){
           if(CanbeMade(bucket, str)){
               if(str.length()==maxlen){
                   result.add(str);
               }

               if(str.length()>maxlen){
                   result.clear();
                   result.add(str);
                   maxlen=str.length();
               }
           }
       }

       return result;
   }

    static  boolean CanbeMade(int[] bucket, String str) {

       for(char ch : str.toCharArray()){
           if(bucket[ch-'a'] ==0){
               return false;
           }
       }

       return true;
    }

    public static void main(String[] args) {
        List<String> input_list = new ArrayList<>(Arrays.asList("to", "banana", "toes", "dogs", "ababcd", "elephant"));
        String input = "ogtdes";
        System.out.println(getLongestString(input_list,input));
    }
}
