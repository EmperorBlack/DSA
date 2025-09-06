package dp.subSetSumEqualsToK;

import java.util.Arrays;

public class SubsetSumDriver {

  public static void main(String[] args) {

    System.out.println(Solution.subsetSumToK(4,4,new int[]{6 ,1 ,2 ,1}));
  }
}

 class Solution {
  public static boolean subsetSumToK(int n, int k, int arr[]){
    // Write your code here.
//
//    int[][] dp = new int[n][k+1];
//
//    for (int i = 0; i < n; i++) {
//      Arrays.fill(dp[i],-1);
//    }
//
//    return subsetSumHelper(arr,n-1,k,dp);
    return subsetSumTab(n,k,arr);

  }

  private static boolean subsetSumHelper(int[] arr,int index, int target, int[][] dp ){


      if(target == 0){
        return true;
      }
    if(index == 0){
      return arr[0] == target;
    }


    if(dp[index][target] != -1){
      return dp[index][target] == 1;
    }

    boolean take = false;

    if(target <= arr[index]) {
      take = subsetSumHelper(arr, index - 1, target, dp);
    }
      boolean notTake = subsetSumHelper(arr, index - 1, target, dp);

      dp[index][target] = (notTake || take) ? 1 : 0;
      return dp[index][target] == 1;


  }

  private static boolean subsetSumTab(int n, int k, int[] arr){


    boolean[][] dp = new boolean[n][k+1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    if(k >= arr[0]){
      dp[0][arr[0]] = true;
    }

    for (int index = 1; index < n; index++) {
      for (int target = 1; target < k+1; target++) {

        boolean pick = false;
        if(arr[index] <= target){
          pick = dp[index-1][target-arr[index]];
        }
        boolean nonPick = dp[index-1][target];
        dp[index][target] = pick || nonPick;

      }

    }
    return dp[n-1][k];


  }
}

