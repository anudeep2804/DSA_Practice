package Stack;

import java.util.Stack;

public class ValidParanthesis {

    public static  boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        boolean isvalid = false;

        if (s.length() <= 1 || s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return isvalid;
        }


        for (int i = 0; i < s.length(); i++) {

            if(stack.isEmpty()==true){
                stack.push(s.charAt(i));
                continue;
            }

            if(stack.peek()=='('){
                if(s.charAt(i)==')'){
                    stack.pop();
                    continue;
                }
                else{
                    stack.push(s.charAt(i));
                    continue;
                }
            }

            if(stack.peek()=='{'){
                if(s.charAt(i)=='}'){
                    stack.pop();
                    continue;
                }
                else{
                    stack.push(s.charAt(i));
                    continue;
                }
            }

            if(stack.peek()=='['){
                if(s.charAt(i)==']'){
                    stack.pop();
                    continue;
                }
                else{
                    stack.push(s.charAt(i));
                    continue;
                }
            }



        }

        if(stack.isEmpty()==true){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        boolean ans = isValid("[{()}]");
        System.out.println(ans);
    }
}
