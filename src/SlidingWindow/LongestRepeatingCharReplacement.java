package SlidingWindow;

public class LongestRepeatingCharReplacement {

    public int characterReplacement(String s, int k) {

        // Solution Ref : https://www.youtube.com/watch?v=00FmUN1pkGE

        /* Basic idea : make a char array to keep counts of each char , in a window
        * check if valid number of replacements can be done , which is see if window length -
        * count of most repeating char , gives us number of replacable char's which should
        * be less than K , if its greater then K slide the window */

        int window_start=0;
        int max_len=0;
        int max_count=0;

        int char_counts[] = new int[26]; // char array that will store counts of each letter at its
        // respective index

        for(int window_end=0;window_end<s.length();window_end++){
            char_counts[(s.charAt(window_end))-'A']++;
            max_count=Math.max(max_count,char_counts[(s.charAt(window_end))-'A']);

            if(window_end-window_start+1-max_count>k){
                char_counts[(s.charAt(window_start))-'A']--;
                window_start++;
            }

            max_len=Math.max(max_len,window_end-window_start+1);

        }
    return max_len;
    }
}
