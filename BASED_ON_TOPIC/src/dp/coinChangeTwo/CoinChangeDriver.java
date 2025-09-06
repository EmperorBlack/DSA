package dp.coinChangeTwo;

import java.util.Arrays;

public class CoinChangeDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().change(5, new int[]{1,2,5}));
  }
}


class Solution {
  public int change(int amount, int[] coins) {

//    int[][] dp = new int[coins.length][amount+1];
//    for (int[] d: dp){
//      Arrays.fill(d,-1);
//    }
//    return changeHelper(amount,coins,coins.length-1,dp);

    return changeTab(amount,coins);

  }

  private int changeHelper(int amount, int[] coins, int index, int[][] dp){

    if(amount == 0){
      return 1;
    }
    if(index == 0){
      return (amount % coins[0] == 0) ? 1 : 0;
    }

    if(dp[index][amount] != -1){
      return dp[index][amount];
    }

    int take = 0;
    if(coins[index] <= amount){
      take = changeHelper(amount-coins[index],coins, index,dp);
    }
    int notTake = changeHelper(amount,coins, index-1,dp);

    int total = take+notTake;
    return dp[index][amount] = total;

  }

  private int changeTab(int amount, int[] coins){
    int[][] dp = new int[coins.length][amount+1];

    for (int i = 0; i < coins.length; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < amount+1; i++) {

      if(i >=coins[0] && ((i % coins[0]) ==0) ){
        dp[0][i] = 1;
      }

    }

    for (int index = 1; index < coins.length; index++) {

      for (int amountDel = 1; amountDel < amount+1 ; amountDel++) {
        int take = 0;
        if(amountDel >= coins[index]){
          take = dp[index][amountDel-coins[index]];
        }
        int notaTake = dp[index-1][amountDel];
        dp[index][amountDel] = take+notaTake;
      }
    }

    return dp[coins.length-1][amount];
  }
}