package Stack;

import java.util.Stack;

public class ValidateStackSequence {


    public  static boolean validateStackSequences(int[] pushed, int[] popped) {

        boolean ans = true;

        if (popped.length != pushed.length) {
            return !ans;
        }

        Stack<Integer> stack = new Stack<>();


        int j = 0;

        for(int val:pushed){
          stack.push(val);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }


        return stack.isEmpty();


    }

    public static void main(String[] args) {
        int[] pushed={1,2,3,4,5};
        int[] popped={4,5,3,2,1};
        boolean ans = validateStackSequences(pushed,popped);
        System.out.println(ans);
    }
}
