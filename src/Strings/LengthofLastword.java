package Strings;

public class LengthofLastword {

    // Char Array based approach

    public int lengthOfLastWord(String s) {

        int counter=0;

        char[] array = s.toCharArray();

        int end = array.length-1;

        for(int i=array.length-1  ;i>=0;i--) {

            if (i != end && array[i] == ' ') {
                return end - i ;
            }

            else  if (array[i] == ' ') {
                end--;
            }

            else{
                counter++;
            }

        }

        return counter;
    }
}

