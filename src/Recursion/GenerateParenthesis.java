package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> output = new ArrayList<>();

        backtrack(output , "", 0,0,n);

        return output;

    }

    private void backtrack(List<String> output, String current_string, int open, int close, int n) {

        if(current_string.length()==n*2){
            output.add(current_string);
            return;
        }

        if(open<n)  backtrack(output, current_string+"(" , open+1, close , n);
        if (close<open) backtrack(output, current_string+")", open, close+1, n);
    }
}
