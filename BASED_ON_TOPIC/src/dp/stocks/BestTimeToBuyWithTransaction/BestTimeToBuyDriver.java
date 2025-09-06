package dp.stocks.BestTimeToBuyWithTransaction;

import java.util.Arrays;

public class BestTimeToBuyDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int maxProfit(int[] prices, int fee) {

    int[][] dp = new int[prices.length][2];
//    for (int i = 0; i < prices.length; i++) {
//      Arrays.fill(dp[i],-1);
//    }
//    return maxProfitHelper(prices,fee,prices.length-1,1,dp);

    dp[0][0] = -prices[0]-fee;

    for (int i = 1; i < prices.length; i++) {
      for (int canSell = 0; canSell < 2 ; canSell++) {

        if(canSell == 1){
          int sell = dp[i-1][0]+prices[i];
          int notSell = dp[i-1][1];
           dp[i][canSell] = Math.max(sell,notSell);
        }else {
          int buy =dp[i-1][1]-prices[i]-fee;
          int notBuy = dp[i-1][0];
           dp[i][canSell] = Math.max(buy,notBuy);
        }

      }
    }
    return dp[prices.length-1][1];


  }

  private int maxProfitHelper(int[] prices, int fee, int i, int canSell, int[][] dp){

    if(i == 0){
      if(canSell==1){
        return 0;
      }else {
        return -prices[0]-fee;
      }
    }


    if(dp[i][canSell] != -1){
      return dp[i][canSell];
    }

    if(canSell == 1){
      int sell = maxProfitHelper(prices,fee,i-1,0,dp)+prices[i];
      int notSell = maxProfitHelper(prices,fee,i-1,1,dp);
      return dp[i][canSell] = Math.max(sell,notSell);
    }else {
      int buy = maxProfitHelper(prices,fee,i-1,1,dp)-prices[i]-fee;
      int notBuy = maxProfitHelper(prices,fee,i-1,0,dp);
      return dp[i][canSell] = Math.max(buy,notBuy);
    }

  }
}