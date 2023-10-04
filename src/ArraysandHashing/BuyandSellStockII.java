package ArraysandHashing;

public class BuyandSellStockII {

    public int maxProfit(int[] prices) {

        int currentprofit=0;
        int totalprofit=0;

        int buyprice=0;
        int sellprice =0;

        for (int i=0;i<prices.length-1;i++){
            buyprice=prices[i];
            sellprice=prices[i+1];

            if(sellprice<=buyprice){
                continue;
            }

            currentprofit=sellprice-buyprice;

            totalprofit=totalprofit+currentprofit;
        }

        return totalprofit;
    }
}
