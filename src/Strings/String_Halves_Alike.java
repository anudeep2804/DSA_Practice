package Strings;

import java.util.ArrayList;
import java.util.List;

public class String_Halves_Alike {

    public boolean halvesAreAlike(String s) {
        int c1=0,c2=0,i=0,j=s.length()-1;
        while(i<j){
            if("aeiouAEIOU".indexOf(s.charAt(i))!=-1) c1++;
            if("aeiouAEIOU".indexOf(s.charAt(j))!=-1) c2++;
            i++;j--;
        }
        return (c1==c2);
    }
}
