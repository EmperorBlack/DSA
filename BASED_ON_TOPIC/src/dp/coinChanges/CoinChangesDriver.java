package dp.coinChanges;

import java.util.Arrays;

public class CoinChangesDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().coinChange(new int[]{1,2,5},11));
  }
}

class Solution {
  public int coinChange(int[] coins, int amount) {

//    int[][] dp = new int[coins.length][amount+1];
//    for(int[] a : dp){
//      Arrays.fill(a,-1);
//    }
//    int ans = coinChangeHelper(coins,amount,coins.length-1, dp);
//
//
//    return ans == Integer.MAX_VALUE ? -1 : ans;
    int ans = coinChangeTab(coins,amount);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  private int coinChangeHelper(int[] coins, int amount, int index,int[][] dp){

    if(amount == 0){
      return 0;
    }

    if(index == 0){
      if(amount%coins[0] == 0){
        return amount/coins[0];
      }else{
        return Integer.MAX_VALUE;
      }
    }

    if(dp[index][amount] != -1){
      return dp[index][amount];
    }

    int choose =Integer.MAX_VALUE;
    if(coins[index] <= amount){
      choose = coinChangeHelper(coins,amount-coins[index],index,dp);
      if (choose != Integer.MAX_VALUE){
        choose = choose+1;
      }
    }
    int notChoose = coinChangeHelper(coins,amount,index-1,dp);

    return dp[index][amount] = Math.min(choose,notChoose);

  }

  private int coinChangeTab(int[] coins, int amount){
    int[][] dp = new int[coins.length][amount+1];

    for (int i = 0; i < amount+1; i++) {

      if(i % coins[0] ==0){
        dp[0][i] = i/coins[0];
      }else{
        dp[0][i] = Integer.MAX_VALUE;
      }
    }

    for (int index = 1; index < coins.length; index++) {

      for (int am = 1; am < amount+1; am++) {

        int take = Integer.MAX_VALUE;
        if(coins[index] <= am){
          take = dp[index][am-coins[index]];
          if(take != Integer.MAX_VALUE){
            take = take+1;
          }
        }
        int notTake = dp[index-1][am];
        dp[index][am] = Math.min(take,notTake);

      }
    }
    return dp[coins.length-1][amount];


  }
}