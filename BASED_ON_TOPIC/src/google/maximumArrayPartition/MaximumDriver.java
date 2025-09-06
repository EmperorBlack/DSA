package google.maximumArrayPartition;

import java.util.Arrays;

public class MaximumDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10},3));
  }
}

class Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {

    int dp[] = new int[arr.length];
    Arrays.fill(dp,-1);
    return countMaxima(arr,k,0, dp);
  }


  private int countMaxima(int[] arr, int k, int index, int[] dp){

    if(index >= arr.length){
      return 0;
    }
    if(dp[index]!= -1){
      return dp[index];
    }

    int max = Integer.MIN_VALUE;
    int maxSum = 0;
    for (int i = index; i < Math.min(arr.length,index+k); i++) {

      max = Math.max(max,arr[i]);
      int sum = countMaxima(arr,k,i+1, dp)+ (max*(i-index+1));
      maxSum = Math.max(sum,maxSum);
    }
    return dp[index] = maxSum;

  }
}