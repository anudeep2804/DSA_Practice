package DesignQuestions;

import java.util.*;

public class AutocompleteSystem {

    Map<String, Integer> sentenceMap;
    StringBuilder currentInput;

    public AutocompleteSystem(String[] sentences, int[] times) {

        this.sentenceMap = new HashMap<>();
        this.currentInput = new StringBuilder();

        for(int i=0; i<sentences.length; i++){
            sentenceMap.put(sentences[i], sentenceMap.getOrDefault(sentences[i], 0)+ times[i]);
        }
    }

    public List<String> input(char c) {

        String inputSentence;

        if(c =='#'){
            inputSentence = currentInput.toString();
            sentenceMap.put(inputSentence, sentenceMap.getOrDefault(inputSentence, 0)+1);
            currentInput = new StringBuilder();
            return new ArrayList<>();
        }

         currentInput.append(c);
         inputSentence = currentInput.toString();

        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String a, String b) {
                // Check if both sentences have the same frequency
                if (Objects.equals(sentenceMap.get(a), sentenceMap.get(b))) {
                    return a.compareTo(b); // Sort lexicographically if frequencies are the same
                }
                // Compare by frequency in descending order
                return Integer.compare(sentenceMap.get(b), sentenceMap.get(a));
            }
        };

        PriorityQueue<String> pq = new PriorityQueue<>(comparator);

         for(String sentence : sentenceMap.keySet()){
             if(sentence.startsWith(inputSentence)){
                 pq.offer(sentence);
             }
         }

         if(pq.size()<3) return new ArrayList<>(pq);

         List<String> ans = new ArrayList<>();

         for(int i=0; i<3; i++){
             ans.add(pq.poll());
         }


         return ans;

    }
}
