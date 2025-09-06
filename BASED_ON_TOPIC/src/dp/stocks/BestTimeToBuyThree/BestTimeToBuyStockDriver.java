package dp.stocks.BestTimeToBuyThree;

import java.util.Arrays;

public class BestTimeToBuyStockDriver {

  public static void main(String[] args) {




  }
}

class Solution {
  public int maxProfit(int[] prices) {

    int[][][] dp = new int[prices.length][2][3];
//
//    for (int i = 0; i < prices.length; i++) {
//      for (int j = 0; j < 2; j++) {
//        Arrays.fill(dp[i][j], -1);
//      }
//    }
//
//    return maxProfitHelper(prices,prices.length-1,1,2,dp);

    for (int j = 1; j < 3; j++) {
      dp[0][0][j] = -prices[0];
    }

    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < 2; j++) {

        for (int k = 1; k <= 2; k++) {

          if(j ==1 ){
            int sell = dp[i-1][0][k]+prices[i];
            int notSell =dp[i-1][1][k];
             dp[i][j][k] = Math.max(sell,notSell);
          }else{
            int buy = dp[i-1][1][k-1]-prices[i];
            int notBuy =dp[i-1][0][k];
             dp[i][j][k] = Math.max(buy,notBuy);
          }

        }
      }
    }

    return dp[prices.length-1][1][2];



  }

  private int maxProfitHelper(int[] prices, int i, int canSell, int maxTran , int[][][] dp){

    if(maxTran == 0){
      return 0;
    }

    if(i == 0){
      if(canSell == 1){
        return 0;
      }else {
        return -prices[0];
      }
    }

    if(dp[i][canSell][maxTran]!= -1){
      return dp[i][canSell][maxTran];
    }

    if(canSell ==1 ){
      int sell = maxProfitHelper(prices,i-1,0,maxTran,dp)+prices[i];
      int notSell = maxProfitHelper(prices,i-1,1,maxTran,dp);
      return dp[i][canSell][maxTran] = Math.max(sell,notSell);
    }else{
      int buy = maxProfitHelper(prices,i-1,1,maxTran-1,dp)-prices[i];
      int notBuy = maxProfitHelper(prices,i-1,0,maxTran,dp);
      return dp[i][canSell][maxTran] = Math.max(buy,notBuy);
    }


  }
}
