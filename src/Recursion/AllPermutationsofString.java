package Recursion;

import SlidingWindow.PermutationinString;

public class AllPermutationsofString {

    public static void PermutationsOfString(String processed, String unprocessed){

        if(unprocessed.isEmpty() ){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        /*
        Calling the recursion based on length of processed length
        for example if processed = a and unprocessed =b; the there are two options that is ba and ab
         */
        for(int i=0;i<=processed.length();i++){

            String first= processed.substring(0,i);
            String last = processed.substring(i);
            PermutationsOfString(first+ch+last , unprocessed.substring(1));
        }
    }

    public static void main(String[] args) {
        PermutationsOfString("","a");
    }
}
