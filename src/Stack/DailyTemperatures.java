package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (
                    !stack.isEmpty() &&
                            temperatures[currDay] > temperatures[stack.peek()]
            ) {
                int previousday = stack.pop();
                ans[previousday] = currDay - previousday;
            }
            stack.add(currDay);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] ans= dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(ans));
    }
}
