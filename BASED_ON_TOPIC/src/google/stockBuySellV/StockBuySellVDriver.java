package google.stockBuySellV;

import java.util.Arrays;

public class StockBuySellVDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().maximumProfit(new int[]{1,7,9,8,2},2));
  }
}

class Solution {
  public long maximumProfit(int[] prices, int k) {

    long[][][] dp = new long[prices.length][k+1][3];
    for (int i = 0; i <  dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        Arrays.fill(dp[i][j],-1);
      }
    }


    return maxProfit(prices, prices.length - 1, k, 0,dp);
  }

  private long maxProfit(int[] prices, int index, int k, int decider, long[][][] dp) {

    if (k == 0 || index < 0) {
      return decider == 0 ? 0 : Integer.MIN_VALUE;
    }

    if(dp[index][k][decider] != -1){
      return dp[index][k][decider];
    }

    long max = Integer.MIN_VALUE;

    if (decider == 0) {
      long shortBuy = maxProfit(prices, index - 1, k, 2,dp);
      if (shortBuy != Integer.MIN_VALUE) shortBuy -= prices[index];

      long sell = maxProfit(prices, index - 1, k, 1,dp);
      if (sell != Integer.MIN_VALUE) sell += prices[index];

      long doNothing = maxProfit(prices, index - 1, k, 0,dp);

      max = Math.max(doNothing, Math.max(sell, shortBuy));

    } else if (decider == 1) {
      long buy = maxProfit(prices, index - 1, k - 1, 0,dp);
      if (buy != Integer.MIN_VALUE) buy -= prices[index];

      long notBuy = maxProfit(prices, index - 1, k, 1,dp);
      max = Math.max(buy, notBuy);

    } else if (decider == 2) {
      long shortSell = maxProfit(prices, index - 1, k - 1, 0,dp);
      if (shortSell != Integer.MIN_VALUE) shortSell += prices[index];

      long notShortSell = maxProfit(prices, index - 1, k, 2,dp);
      max = Math.max(shortSell, notShortSell);
    }

    return dp[index][k][decider] = max;
  }
}
