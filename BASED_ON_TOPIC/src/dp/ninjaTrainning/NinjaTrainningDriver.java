package dp.ninjaTrainning;

import java.util.Arrays;

public class NinjaTrainningDriver {

}

class Solution {
  public static int ninjaTraining(int n, int points[][]) {

    // Write your code here..

    int[][] dp = new int[n][4];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 4; j++) {
        dp[i][j] = -1;
      }

    }

//    return calMaxPoints(n-1,points,3,dp);
    return ninjaTrainingTab(n,points,dp);
  }

  private static int calMaxPoints(int n, int[][] points, int lastTask, int[][] dp){


    if(n == 0){
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < 3; i++) {
        if(i != lastTask && max < points[0][i]){
          max = points[0][i];
        }
      }
      return dp[n][lastTask] = max;
    }

    if(dp[n][lastTask] != -1){
      return dp[n][lastTask];
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < 3; i++) {
      if(i!= lastTask){
        int ans = calMaxPoints(n-1,points,i,dp)+ points[n][i];
        if(max < ans){
          max = ans;
        }
      }
    }

    return dp[n][lastTask] = max;

  }

  private static int ninjaTrainingTab(int n, int[][] points, int[][] dp){

   dp[0][0] = Math.max(points[0][1],points[0][2]);
   dp[0][1] = Math.max(points[0][0],points[0][2]);
   dp[0][2] = Math.max(points[0][1],points[0][0]);
   dp[0][3] = Math.max(Math.max(points[0][1],points[0][2]),points[0][0]);

    for (int days = 1; days < n; days++) {

      for (int task = 0; task < 4; task++) {// last

        int max = Integer .MIN_VALUE;
        for (int i = 0; i < 3; i++) {
          if(i!= task){

            int ans = dp[days-1][i] + points[days][i];
            max = Math.max(ans,max);
          }
        }
        dp[days][task] = max;

      }

    }

    return dp[n-1][3];

  }

}

