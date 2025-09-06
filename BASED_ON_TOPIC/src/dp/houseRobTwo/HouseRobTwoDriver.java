package dp.houseRobTwo;

import java.util.Arrays;

public class HouseRobTwoDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().rob(new int[]{1,2}));
  }
}

class Solution {
  public int rob(int[] nums) {

    if(nums.length == 1){
      return nums[0];
    }
    int[] dp = new int[nums.length];
    Arrays.fill(dp,-1);
    int result1 = houseRobHelper(nums, nums.length-1,1,dp);
    Arrays.fill(dp,-1);
    int result2 = houseRobHelper(nums, nums.length-2,0,dp);
    return Math.max(result1,result2);

  }

  private int houseRobHelper(int[] nums, int n, int start, int[] dp){

    if(n ==start){
      return nums[start];
    }

    if(n == start+1){
      return Math.max(nums[start],nums[start+1]) ;
    }

    if(dp[n] != -1)
    {
      return dp[n];
    }
    int chose = houseRobHelper(nums, n-2, start, dp)+ nums[n];
    int notChose = houseRobHelper(nums, n-1, start, dp);

    return dp[n] = Math.max(chose,notChose);


  }
}