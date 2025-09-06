package dp.unboundedKnapSack;

import java.util.Arrays;

public class UnboundedKnapsackDriver {

}


class Solution {
  public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

    int[][] dp = new int[n][w+1];
    for (int i = 0; i < dp.length ; i++) {
      Arrays.fill(dp[i],-1);
    }

//    return knapsackHelper(weight,profit,n-1,w,dp);

    return knapsackTab(weight,profit,n,w);


  }

  static int knapsackHelper(int[] weight, int[] value, int index, int maxWeight, int[][] dp){

    if(maxWeight == 0){
      return 0;
    }
    if(index ==0){
      if(maxWeight >= weight[0]){
        return (maxWeight/weight[0]) * value[0];
      }
      return 0;
    }

    if(dp[index][maxWeight] != -1){
      return dp[index][maxWeight];
    }

    int take = 0;
    if(maxWeight >= weight[index]){
      take = knapsackHelper(weight,value,index,maxWeight-weight[index],dp) + value[index];
    }
    int notTake = knapsackHelper(weight,value,index-1,maxWeight,dp);

    return dp[index][maxWeight] = Math.max(take,notTake);


  }



  static int knapsackTab(int[] weight, int[] value, int n, int maxWeight){

    int[][] dp = new int[n][maxWeight+1];


    for (int i = 0; i < maxWeight+1; i++) {
      if(i >= weight[0]){
        dp[0][i] = (i/weight[0])*value[0];
      }
    }

    for (int index = 1; index < n ; index++) {

      for (int delWeight = 1; delWeight < maxWeight+1; delWeight++) {

        int take = 0;
        if(delWeight >= weight[index]){
          take = dp[index][delWeight-weight[index]]+value[index];
        }
        int notTake = dp[index-1][delWeight];

        dp[index][delWeight] = Math.max(take,notTake);
      }
    }


    return dp[n-1][maxWeight];

  }
}