package Stack;

import java.util.Stack;

public class MiniStackusingStack {


    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_values= new Stack<>();

    int min_value=Integer.MAX_VALUE;

    public void MinStack() {

    }

    public void push(int val) {
      stack.push(val);

        if(min_values.isEmpty()){
            min_values.push(val);
        }

      if(val<min_values.peek()){
          min_values.push(val);
      }

    }

    public void pop() {

        if(stack.peek().equals(min_values.peek())){
            min_values.pop();
        }

        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
      return min_values.peek();
    }
}
