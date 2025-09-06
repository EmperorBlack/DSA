package dp.partitionDP.mcm;

import java.util.Arrays;
import java.util.Map;

public class MCMDriver {

}

class Solution {
  public static int matrixMultiplication(int[] arr , int N) {

    int[][] dp = new int[N][N];
    for (int d[] : dp){
      Arrays.fill(d,-1);
    }

    return matrixChainMul(arr,1,N-1, dp);


  }


  private static int matrixChainMul(int[] arr, int i , int j, int[][] dp){


    if(i ==j){
      return 0;
    }

    if(dp[i][j] != -1){
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int steps = matrixChainMul(arr,i,k,dp)+ matrixChainMul(arr,k+1,j, dp) + (arr[i-1] * arr[k] * arr[j]);
      min = Math.min(min,steps);
    }
    return dp[i][j] = min;

  }
}

class SolutionBottomUp {
  public static int matrixMultiplication(int[] arr , int N) {

    int dp[][] = new int[N][N];

    for(int i = N-1; i>=1;i--){
      for (int j = i+1; j <= N-1; j++) {

        int minSteps = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {

          int steps = (arr[i-1] * arr[k] * arr[j]) + dp[i][k]+dp[k+1][j];
          minSteps = Math.min(minSteps,steps);
        }
        dp[i][j] = minSteps;
      }
    }
    return dp[1][N-1];

  }
}


