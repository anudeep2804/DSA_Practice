package DesignQuestions;

import java.util.LinkedList;

class MinStack {

    LinkedList<TplusMin> stackLL;

    static class TplusMin{
        int val;
        int min;

        TplusMin(int val, int min){
            this.val = val;
            this.min=min;
        }

    }


    public MinStack() {
        stackLL = new LinkedList<>();
    }

    public void push(int val) {
        int newMin;

        if(stackLL.isEmpty()){
            newMin = val;
            stackLL.addFirst(new TplusMin(val, newMin));
        }
        else {
            int currentMin  = stackLL.getFirst().min;

            newMin = Math.min(currentMin, val);

            stackLL.addFirst(new TplusMin(val, newMin));

        }
    }

    public void pop() {
        stackLL.removeFirst();
    }

    public int top() {
        return stackLL.getFirst().val;
    }

    public int getMin() {
        return stackLL.getFirst().min;
    }
}
