package SlidingWindow;



public class StockBuySell {

        public static int maxProfit(int[] prices) {
            int left = 0;
            int right = 1;
            int maxProfit = 0;
            while (right < prices.length) {
                if (prices[left] < prices[right]) {
                    maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                    right++;
                } else {
                    left = right;
                    right++;
                }
            }
            return maxProfit;

        }


    public static void main(String[] args) {
        int input[]= {2,1,4};
        System.out.println(maxProfit(input));
    }
}
