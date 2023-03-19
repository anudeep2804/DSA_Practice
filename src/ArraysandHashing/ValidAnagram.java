package ArraysandHashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        //Naive Approach

        boolean isAnagram=false;

        char[] Sarray=s.toCharArray();
        char[] Tarray=t.toCharArray();

        Arrays.sort(Sarray);
        Arrays.sort(Tarray);

        if(Sarray.length==Tarray.length){

            for(int i=0;i<Sarray.length;i++){
                if(Sarray[i] !=Tarray[i]){
                    return false;
                }
                else{
                    isAnagram=true;
                }
            }
        }

        return isAnagram;

    }

    public boolean isAnagramoptimal(String s, String t){


        HashMap<Character,Integer> Shash= new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            Shash.put(ch,Shash.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char cht=t.charAt(i);

            if(Shash.containsKey(cht)==false){
                 return false;
            }
            else {
                if(Shash.get(cht)==1){
                    Shash.remove(cht);
                } else if (Shash.get(cht)>1) {
                    Shash.put(cht,Shash.get(cht)-1);
                }
            }

        }

        return Shash.isEmpty();
    }
}
