package Stack;

import java.util.Stack;

public class ValidParanthesis {

    public static  boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        boolean isvalid=false;

        if(s.length()<=1){
            return isvalid;
        }

        if(s.charAt(0)==')'){
            return isvalid;
        }

        if(s.charAt(0)=='}'){
            return isvalid;
        }

        if(s.charAt(0)==']'){
            return isvalid;
        }

        stack.push(s.charAt(0));

        for(int i=1;i<s.length();i++){
            if(stack.peek()=='(' || stack.isEmpty()==true){
                if(s.charAt(i)==')'){
                    stack.pop();
                    continue;
                }
                else{
                    stack.push(s.charAt(i));
                    continue;
                }
            }

            if(stack.peek()=='{' || stack.isEmpty()==true){
                if(s.charAt(i)=='}'){
                    stack.pop();
                    continue;
                }
                else{
                    stack.push(s.charAt(i));
                    continue;
                }
            }

            if(stack.peek()=='[' || stack.isEmpty()==true){
                if(s.charAt(i)==']'){
                    stack.pop();continue;
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

        else {
            return false;
        }

    }

    public static void main(String[] args) {
        boolean ans = isValid("(){}[]");
        System.out.println(ans);
    }
}
