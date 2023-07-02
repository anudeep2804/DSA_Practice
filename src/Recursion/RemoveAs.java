package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RemoveAs {

    public  static String RemoveAllAs ( String s , StringBuilder stringBuilder  , int i ) {

        if(i==s.length()){
            return  stringBuilder.toString();
        }

        if(s.charAt(i)!='a'){
            stringBuilder.append(s.charAt(i));
        }

        return RemoveAllAs(s,stringBuilder,++i);
    }

    public static void main(String[] args) {

        String s = "abab___///@#^dabc";
        boolean bool = s.contains("abc");
        StringBuilder stringBuilder = new StringBuilder();
        String ans = RemoveAllAs(s,stringBuilder,0);
        System.out.println(bool);

    }




}

