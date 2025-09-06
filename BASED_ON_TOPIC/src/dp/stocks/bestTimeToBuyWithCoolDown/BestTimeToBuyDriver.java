package dp.stocks.bestTimeToBuyWithCoolDown;

import java.util.Arrays;

public class BestTimeToBuyDriver {

}


class Solution {
  public int maxProfit(int[] prices) {

    int[][][] dp = new int[prices.length+1][2][2];
//    for (int i = 0; i < prices.length; i++) {
//      for (int j = 0; j < 2; j++) {
//        Arrays.fill( dp[i][j],-1);
//      }
//    }
//
//
//    return maxProfitHelper(prices,0,1,0,dp);

    for (int i = prices.length - 1; i >= 0; i--) {
      for (int canBuy = 0; canBuy <= 1; canBuy++) {
        for (int coolDown = 0; coolDown <= 1; coolDown++) {

          if (canBuy == 1) {
            int notBuy = dp[i + 1][1][(coolDown == 1) ? 0 : coolDown];
            int buy = (coolDown == 0) ? dp[i + 1][0][coolDown] - prices[i] : Integer.MIN_VALUE;

            dp[i][canBuy][coolDown] = Math.max(buy, notBuy);

          } else {
            int sell = dp[i + 1][1][1] + prices[i];  // after sell, cooldown starts
            int notSell = dp[i + 1][0][coolDown];

            dp[i][canBuy][coolDown] = Math.max(sell, notSell);
          }

        }
      }
    }


    return dp[0][1][0];


  }


  private int maxProfitHelper(int[] prices, int i, int canBuy, int coolDown, int[][][] dp){


    if(i == prices.length){
        return 0;
    }

    if(dp[i][canBuy][coolDown] != -1){
      return dp[i][canBuy][coolDown];
    }


    if(canBuy == 1 ){

      int notBuy;
      int buy = Integer.MIN_VALUE;
      if(coolDown == 1){
        notBuy = maxProfitHelper(prices,i+1,1,0,dp);
      }else{
        notBuy = maxProfitHelper(prices,i+1,1,coolDown,dp);
        buy = maxProfitHelper(prices,i+1,0,coolDown,dp)-prices[i];
      }
      return dp[i][canBuy][coolDown] = Math.max(buy,notBuy);
    }else{
      int sell = maxProfitHelper(prices,i+1,1,1,dp)+prices[i];
      int  notSell = maxProfitHelper(prices,i+1,0,coolDown,dp);
      return dp[i][canBuy][coolDown] = Math.max(sell,notSell);
    }



  }
}
