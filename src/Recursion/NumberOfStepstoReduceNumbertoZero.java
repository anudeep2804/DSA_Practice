package Recursion;

//Leetcode 1342 : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

public class NumberOfStepstoReduceNumbertoZero {

    public static  int numberOfSteps(int num) {

        if(num==0){
            return 0;
        }

        if(num%2==0){
            return 1+numberOfSteps(num/2);
        }
        else {
           return  1+numberOfSteps(num-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }


}
