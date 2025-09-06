package dp.partitionEqualSubset;

import java.util.Arrays;
import java.util.stream.Stream;

public class PartitionEqualSubsetDriver {

}

class Solution {
  public boolean canPartition(int[] nums) {

    int sum = Arrays.stream(nums).sum();
    if(sum % 2 != 0){
      return false;
    }
    return subSetSumEqualsToK(nums.length, sum/2,nums);


  }

  private boolean subSetSumEqualsToK(int n, int k, int arr[]){
    // Write your code here.

    boolean[][] dp = new boolean[n][k+1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    if(k >= arr[0]){
      dp[0][arr[0]] = true;
    }

    for (int index = 1; index < n; index++) {

      for (int target = 1; target < k+1; target++) {
        // if we take the current element
        boolean take = false;
        if(target >= arr[index]){
          take = dp[index-1][target-arr[index]];
        }
        boolean notTake = dp[index-1][target];
        dp[index][target] = take || notTake;
      }

    }

    return dp[n-1][k];
  }
}
