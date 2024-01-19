package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Print_Possible_Strings {

    public static List<String> Combinations(int size, int d , int t){

        List<String> result = new ArrayList<>();

        helper(size, "",d , t, 0 , 0, result);

        return result;
    }

    private  static void helper(int size, String p, int d, int t, int zerocounter , int onecounter, List<String> result) {

        if(p.length()==size){
            result.add(p);
            return;
        }

        if(zerocounter<d){
            String temp= p+"0";
            zerocounter++;
            helper(size, temp, d, t , zerocounter , 0 ,result);
        }

        if(onecounter<t){
            String temp1= p+"1";
            onecounter++;

            helper(size, temp1, d, t , 0 , onecounter ,result);
        }


    }

    public static void main(String[] args) {
        List<String> result = Combinations(10,1,9);
        System.out.println(result);
    }
}
