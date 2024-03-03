package Strings;

import java.util.ArrayList;

//https://leetcode.com/problems/reverse-words-in-a-string/description/

public class ReverseWords {

    public String reverseWords(String s) {

        if (s.length() <= 1) return s;

        s = s.trim();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ') {
                StringBuilder sb = new StringBuilder();
                int j = i;
                while (j <= s.length() - 1 && s.charAt(j) != ' ') {
                    sb.append(s.charAt(j));
                    j++;
                }

                list.add(sb.toString());
                i = j - 1;
            } else {
                StringBuilder sb = new StringBuilder();
                int j = i;

                while (j <= s.length() - 1 && s.charAt(j) == ' ') {
                    j++;
                }
                sb.append(' ');

                list.add(sb.toString());
                i = j - 1;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            ans.append(list.get(i));
        }

        return ans.toString();
    }
}
