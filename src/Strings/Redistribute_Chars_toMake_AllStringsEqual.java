package Strings;

public class Redistribute_Chars_toMake_AllStringsEqual {

    //https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/?envType=daily-question&envId=2023-12-30
    public boolean makeEqual(String[] words) {

        boolean result = true;

        int[] chararray = new int[26];

        for(String word : words){
            for(int i=0; i< word.length(); i++){
                int index= word.charAt(i)-'a';

                chararray[index] = chararray[index]+1;
            }
        }

        for(int i=0; i<26;i++){
            if(chararray[i]==0) continue;
            else if ( chararray[i]% words.length !=0) {
                return false;
            }
        }


        return  result;

    }
}
