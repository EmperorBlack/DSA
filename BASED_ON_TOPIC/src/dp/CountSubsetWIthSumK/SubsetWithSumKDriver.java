package dp.CountSubsetWIthSumK;

import java.util.Arrays;

public class SubsetWithSumKDriver {

  public static void main(String[] args) {

    System.out.println(Solution.findWays(new int[]{0,1,3},4));
  }
}

class Solution {

  public static int findWays(int num[], int tar) {


//    int[][] dp = new int[num.length][tar+1];
//    for (int[] d : dp){
//      Arrays.fill(d, -1);
//    }
//
//    return findWaysHelper(num, tar, num.length-1,dp );

    return findWaysTab(num,tar);

  }

  private static int findWaysHelper(int num[], int tar, int index, int[][] dp) {


    if(index == 0){
      if(tar == 0 && num[0] ==0){
        return 2;
      }
      if(tar == 0 || tar == num[0]){
        return 1;
      }
      return 0;
    }

    if(dp[index][tar] != -1) {
      return dp[index][tar];
    }

    int take = 0;
    if(num[index] <= tar){
      take = findWaysHelper(num, tar - num[index], index - 1, dp);
    }
    int notTake = findWaysHelper(num, tar, index-1,dp);

    return dp[index][tar] = (take+notTake) %1000000007;


  }

  private static int findWaysTab(int num[], int tar){

    int[][] dp = new int[num.length][tar+1];

    for (int i = 0; i < num.length; i++) {
      dp[i][0] = 1;
    }

    if(num[0] == 0){
      dp[0][0] = 2;
    }


    if(num[0] <= tar){
      dp[0][num[0]] = 1;
    }

    for (int i = 1; i < num.length; i++) {

      for (int j = 0; j < tar+1; j++) {

        int take = 0;
        if(num[i] <= j){
          take = dp[i- 1][j-num[i]];
        }
        int notTake = dp[i- 1][j];
        dp[i][j] = (take+notTake)%1000000007;

      }


    }


    return dp[num.length-1][tar];
  }
}
