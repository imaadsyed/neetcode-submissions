class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];
            int maxSellPrice = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > maxSellPrice) {
                    maxSellPrice = prices[j];
                }
            }
            
            int net = maxSellPrice - buyPrice;
            System.out.println("BuyPrice: " + buyPrice);
            System.out.println("Sell Price: " + maxSellPrice);
            System.out.println("Net: " + net);
            System.out.println();

            if (net > maxProfit) {
                maxProfit = net;
            }
        }

        return maxProfit;    
    }
}    
