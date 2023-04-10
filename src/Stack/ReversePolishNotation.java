package Stack;

import java.util.Stack;

public class ReversePolishNotation {

    public static  int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int ans;

        for(int i=0;i< tokens.length;i++){

            if(!tokens[i].equals("+") && !tokens[i].equals("/") && !tokens[i].equals("*") && !tokens[i].equals("-")) {
                stack.push(Integer.parseInt(tokens[i]));
            }

         //  System.out.println(stack);

            if(tokens[i].equals("+")){
                ans= stack.pop()+stack.pop();
              // System.out.println(ans);
                stack.push(ans);
            }

            if(tokens[i].equals("/")){
                int val=stack.pop();
                int val2= stack.pop();
                ans=val2/val;
                System.out.println(ans);
                stack.push(ans);
            }

            if(tokens[i].equals("*")){
                ans= stack.pop()*stack.pop();
                //System.out.println(ans);
                stack.push(ans);
            }

            if(tokens[i].equals("-")){
                int val1=stack.pop();
                int val2= stack.pop();
                ans= val2-val1;
              // System.out.println(ans);
                stack.push(ans);
            }

        }

        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
