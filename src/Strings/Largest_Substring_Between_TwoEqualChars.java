package Strings;

public class Largest_Substring_Between_TwoEqualChars {

    public int maxLengthBetweenEqualCharacters(String s) {

        int result = Integer.MIN_VALUE;

        int[] chararray = new int[26];
        int[] indexarray = new int[26];

        for (int i = 0; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';

            if (chararray[index] >= 1) {
                int val = i - indexarray[index] - 1;
                if (val > result) {
                    result = val;
                }

            } else {
                chararray[index] = chararray[index] + 1;
                indexarray[index] = i;
            }
        }

        if (result == Integer.MIN_VALUE) {
            return -1;
        } else return result;
    }
}
