package dp.stocks.BestTimeToBuyTwo;

import java.util.Arrays;

public class BestTimeToBuyDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int maxProfit(int[] prices) {

    int[][] dp = new int[prices.length][2];
//    for (int i = 0; i < dp.length; i++) {
//      Arrays.fill(dp[i],-1);
//    }
//
//    return maxProfitHelper(prices.length-1,1,prices,dp);

    dp[0][0] = -prices[0];
    dp[0][1] = 0;

    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < 2; j++) {

        int maxProfit = Integer.MIN_VALUE;
        if(j ==1){
          int selling = dp[i-1][0] + prices[i];
          int notSelling = dp[i-1][1];
          maxProfit = Math.max(selling,notSelling);
        }else{
          int buying = dp[i-1][1] - prices[i];
          int notBuying = dp[i-1][0];
          maxProfit = Math.max(buying,notBuying);
        }
        dp[i][j] = maxProfit;
      }
    }
    return dp[prices.length-1][1];

  }

  private int maxProfitHelper(int pIndex, int canSell, int[] prices, int[][] dp){

    if(pIndex == 0){
      if(canSell == 1){
        return 0;
      }else{
        return -prices[0];
      }
    }

    if(dp[pIndex][canSell] != -1){
      return dp[pIndex][canSell];
    }

    int maxProfit = Integer.MIN_VALUE;
    if(canSell ==1){
      int selling = maxProfitHelper(pIndex-1,0,prices,dp)+ prices[pIndex];
      int notSelling = maxProfitHelper(pIndex-1,1,prices,dp);
      maxProfit = Math.max(selling,notSelling);
    }else{
      int buying = maxProfitHelper(pIndex-1,1,prices,dp)-prices[pIndex];
      int notBuying = maxProfitHelper(pIndex-1,0,prices,dp);
      maxProfit = Math.max(buying,notBuying);
    }
    return dp[pIndex][canSell] = maxProfit;
  }
}