package dp.ZeroOneKnapSack;

import java.util.Arrays;

public class ZeroOneKnapsackDriver {

  public static void main(String[] args) {

  }
}



class Solution {

  static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//
//    int[][] dp = new int[n][maxWeight+1];
//
//    for(int[] d : dp){
//
//      Arrays.fill(d,-1);
//
//    }


//    return knapsackHelper(weight,value,n-1,maxWeight,dp);
    return knapsackTab(weight,value,n, maxWeight);

  }

  static int knapsackHelper(int[] weight, int[] value, int index, int maxWeight, int[][] dp){

    if(maxWeight == 0){
      return 0;
    }
    if(index ==0){
      if(maxWeight >= weight[0]){
        return value[0];
      }
      return 0;
    }

    if(dp[index][maxWeight] != -1){
      return dp[index][maxWeight];
    }

    int take = 0;
    if(maxWeight >= weight[index]){
      take = knapsackHelper(weight,value,index-1,maxWeight-weight[index],dp) + value[index];
    }
    int notTake = knapsackHelper(weight,value,index-1,maxWeight,dp);

    return dp[index][maxWeight] = Math.max(take,notTake);


  }

  static int knapsackTab(int[] weight, int[] value, int n, int maxWeight){

    int[][] dp = new int[n][maxWeight+1];


    for (int i = 0; i < maxWeight+1; i++) {
      if(i >= weight[0]){
        dp[0][i] = value[0];
      }
    }

    for (int index = 1; index < n ; index++) {

      for (int delWeight = 1; delWeight < maxWeight+1; delWeight++) {

        int take = 0;
        if(delWeight >= weight[index]){
          take = dp[index-1][delWeight-weight[index]]+value[index];
        }
        int notTake = dp[index-1][delWeight];

        dp[index][delWeight] = Math.max(take,notTake);
      }
    }


    return dp[n-1][maxWeight];

  }

}