package Tries;



import java.util.List;

public class WordBreak {

    //  https://leetcode.com/problems/word-break/description/


      //Dp based solution , optimal
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[s.length()] = true;

            for(int i = s.length()-1; i >= 0; i--){
                for(String w: wordDict){
                    if((i + w.length()) <= s.length() && s.startsWith(w, i)){
                        dp[i] = dp[i + w.length()];
                    }
                    if(dp[i]){
                        break;
                    }
                }
            }
            return dp[0];
        }



        /* Beats 30%

    public boolean wordBreak( String s , List<String> wordDict){
        boolean[] table = new boolean[s.length()];



        for(int i=0;i<table.length;i++){
            for(int y=0;y<=i;y++){
                if(y==0 || table[y-1]){
                    if(wordDict.contains(s.substring(y,i+1))){
                        table[i]=true;
                        break;
                    }
                }
            }
        }

        return table[table.length-1];
    }

*/


    /*
    Trie based Approach , gives TLE


    private Node root = new Node(); // Initialize the root node

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) return false; // Check if the dictionary is empty
        ListtoTrie(wordDict);
        return wordBreakhelper(s);
    }

    private boolean wordBreakhelper(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }

        for (int i = 1; i <= len; i++) {
            if (search(s.substring(0, i)) && wordBreakhelper(s.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public void ListtoTrie(List<String> wordDict) {
        for (String str : wordDict) {
            insert(str);
        }
    }

    public boolean search(String word) {
        Node res = getLast(word);
        return (res != null && res.isWord);
    }

    public Node getLast(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            if (curr.children[x - 'a'] == null) {
                return null;
            }
            curr = curr.children[x - 'a'];
        }
        return curr;
    }

    class Node {
        private boolean isWord;
        private Node[] children;

        public Node() {
            this.isWord = false;
            this.children = new Node[26]; // For 26 lowercase letters
        }
    }

    public void insert(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            if (curr.children[x - 'a'] == null) {
                curr.children[x - 'a'] = new Node();
            }
            curr = curr.children[x - 'a'];
        }
        curr.isWord = true;
    }
  */


    /*
    Recursive Approach , Gives TLE

    public boolean wordBreak(String s, List<String> wordDict) {
    if (s.isEmpty()) {
        return true;
    }

    for (int i = 1; i <= s.length(); i++) {
        if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)) {
            return true;
        }
    }

    return false;
}



    //


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                s = s.substring(i);
                System.out.println(s);
                if (s.isEmpty()|| wordDict.contains(s)) {
                    return true;
                }
                i = 0; // Reset i to 0 instead of 1
            }
        }

        return false;
    }

 */





}
