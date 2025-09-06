package dp.rodCutting;

import java.util.Arrays;

public class RodCuttingDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public static int cutRod(int price[], int n) {
    // Write your code here.

    int[][] dp = new int[price.length][n+1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i],-1);
    }

    return cutRodHelper(price,n, price.length-1, dp);

  }

  private static int cutRodHelper(int price[], int n, int index, int[][] dp){


    if(index ==0){
      return n*price[0];
    }

    if(dp[index][n] != -1){
      return dp[index][n];
    }

    int take = 0;
    if(n >= index+1){
      take = cutRodHelper(price,n-(index+1),index,dp)+price[index];
    }
    int notTake = cutRodHelper(price,n,index-1,dp);

    return dp[index][n] =Math.max(take,notTake);

  }

  private static int cutRodTab(int price[], int n, int index){

    int[][] dp = new int[price.length][n+1];

    for (int i = 0; i < n+1; i++) {

      dp[0][i] = i*price[0];
    }

    for (int i = 1; i < price.length; i++) {

      for (int j = 0; j < n+1; j++) {


        int take =0;
        int rodLen = index+1;
        if(j >= rodLen){
          take = price[index] + dp[index][j - rodLen];
        }
        int notTake = dp[index - 1][j];
        dp[index][j] = Math.max(take, notTake);

      }
    }
    return dp[price.length-1][n];

  }
}