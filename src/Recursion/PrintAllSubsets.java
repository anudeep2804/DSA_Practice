package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {

    public  List<String> printallSubsets(String s){

         List<String> result = printsubstrings( "", s);

         return result;
    }

    private List<String> printsubstrings(String processed, String unprocessed) {

        if(unprocessed.isEmpty()){
            ArrayList<String>  arrayList= new ArrayList<>();
            arrayList.add(processed);
            return arrayList;
        }
        char ch = unprocessed.charAt(0);
      List<String> processedlist =  printsubstrings(processed+ch, unprocessed.substring(1)); // take first char from unprocessed to processed
        List<String> unprocessedlist = printsubstrings(processed,unprocessed.substring(1)); // ignore first char in unprocessed and move on

        processedlist.addAll(unprocessedlist);

        return processedlist;
    }

    public static void main(String[] args) {
        PrintAllSubsets printAllSubsets = new PrintAllSubsets();
        List<String> ans = printAllSubsets.printallSubsets("abc");
        System.out.println(ans);
    }


}
