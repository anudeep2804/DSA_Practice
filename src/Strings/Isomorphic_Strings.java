package Strings;

import java.util.ArrayList;
import java.util.List;

public class Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {


        boolean result = false;

        if (s.length() != t.length()) {
            return result;
        }

        List<Integer> arrary1[] = new List[256];
        List<Integer> array2[] = new List[256];

        for(int i=0; i<256; i++){
            array2[i] = new ArrayList<>();
            arrary1[i] = new ArrayList<>();
        }

        for(int i=0 ;i<s.length();i++){
            int index1= s.charAt(i);
            int index2= t.charAt(i);

            arrary1[index1].add(i);
            array2[index2].add(i);

            if(!(arrary1[index1].equals(array2[index2]))){
                return result;
            }
        }

        return true;

    }
}
