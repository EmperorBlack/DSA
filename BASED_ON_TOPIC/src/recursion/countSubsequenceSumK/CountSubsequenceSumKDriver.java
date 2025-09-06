package recursion.countSubsequenceSumK;

import com.sun.source.tree.BreakTree;
import java.util.Arrays;

public class CountSubsequenceSumKDriver {

  public static void main(String[] args) {

    System.out.println(Solution_CN.isSubsetPresent(5, 14, new int[]{4, 2, 5, 6, 7}));
  }
}


class Solution {
  // Function to calculate the number of subsets with a given sum
//  2^n (number of zero ) * ans is ans.
  public int perfectSum(int[] nums, int target) {

    int dp[][] = new int[nums.length][target+1];
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] ==0){
        count++;
      }
      Arrays.fill(dp[i],-1);
    }
    return (int)(perfectSum(nums,target, nums.length-1,dp));
  }

  public int perfectSum(int[] nums, int target, int index, int [][] dp) {

    if(target == 0){
      int count = 0;
      for (int i = index; i >=0 ; i--) {
        if(nums[i] == 0){
          count++;
        }
      }
      return (int)Math.pow(2,count);
    }
    if(index < 0){
      return 0;
    }

    if(dp[index][target] != -1){
      return dp[index][target];
    }

    int take = 0;
    int notTake = 0;

    if(nums[index] <= target){
      take = perfectSum(nums,target-nums[index],index-1,dp);
    }
    notTake = perfectSum(nums,target,index-1,dp);

    return dp[index][target] = take + notTake;

  }
}

class Solution_CN {
  public static boolean isSubsetPresent(int n, int k,int []a) {
    // Write your code here
    int[][] dp = new int[a.length][k+1];
    for (int[] d : dp){
      Arrays.fill(d,-1);
    }
    return isPresent(k, a, n - 1, dp) == 1;
  }

  public static int isPresent(int k, int []a, int index, int[][] dp){

    if(k == 0){
      return 1;
    }
    if(index < 0){
      return 0;
    }

    if(dp[index][k] != -1){
      return dp[index][k];
    }

    int take = 0;
    if(k >= a[index]) {
      take = isPresent(k - a[index], a, index - 1, dp);
    }
    int notTake = isPresent(k,a,index-1,dp);

    return  dp[index][k] = (take == 1 || notTake == 1 ? 1 : 0);

  }
}
