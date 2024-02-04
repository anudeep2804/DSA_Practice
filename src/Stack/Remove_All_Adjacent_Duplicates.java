package Stack;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates {

    public String removeDuplicates(String s, int k) {

        Stack<Character> char_stack = new Stack<>();
        Stack<Integer> count_stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(char_stack.size()>0 && char_stack.peek()==ch){
                count_stack.push(count_stack.peek()+1);
            }
            else{
                count_stack.push(1);
            }

               char_stack.push(ch);
            if(count_stack.peek()==k){
                for(int i=0; i<k; i++){
                    char_stack.pop();
                    count_stack.pop();
                }
            }
        }


        StringBuilder str = new StringBuilder();

        while(!char_stack.isEmpty()){
            str.append(char_stack.pop());
        }

        return str.reverse().toString();
    }
}
