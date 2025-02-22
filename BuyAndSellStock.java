public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] stocks = {2, 1, 3, 5, 6, 4};
        int maxProfit = maxProfit(stocks);
        System.out.println(maxProfit);
    }
    // 2, 1, 3, 6, 5, 4 | boughtStock = 1, profit = currentStock - stockPrice, maxProfit = Maximum between profit and maxProfit
    //          ^
    //
    public static int maxProfit(int[] prices) {
        int boughtStockPrice = prices[0], maxProfit = 0;
        for (int price : prices) {
            // buy the stock if when the price is low.
            if (boughtStockPrice > price)
                boughtStockPrice = price;
            // Now calculate the profit | currentStockPrice - boughtStockPrince
            int profit = price - boughtStockPrice;
            // if profit is not zero check try to store max profit everytime
            if (profit > 0)
                maxProfit = Math.max(maxProfit, profit);
        }
        // at the end return the maxProfit
        return maxProfit;
    }
}
