package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class pair{
    String word;
    int steps;

    public pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

public class Word_Ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;

        Queue<pair> queue = new LinkedList<>();

        queue.add(new pair(beginWord ,1));

        set.remove(beginWord);

        while (!queue.isEmpty()){
            String word =queue.peek().word;
            int steps = queue.peek().steps;

            queue.remove();

            if(word.equals(endWord)) return steps;

            for(int i=0; i<word.length(); i++){
                for(char ch ='a'; ch<='z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new pair(replacedWord, steps+1));
                    }
                }
            }
        }

return 0;
    }
}
