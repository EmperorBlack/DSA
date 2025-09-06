package dp.houseRob;

import java.util.Arrays;

public class HouseRobDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().rob(new int[]{1,2,3,1}));
  }
}

class Solution {
  public int rob(int[] nums) {

    int[] dp = new int[nums.length];
    Arrays.fill(dp,-1);

//    return houseRobHelper(nums,nums.length-1,dp);
return houseRobTab(nums,nums.length,dp);

  }

  private int houseRobHelper(int[] nums, int n, int[] dp){


    if(n ==0){
      return nums[0];
    }

    if(n == 1){
      return Math.max(nums[0],nums[1]) ;
    }

    if(dp[n] != -1){
      return dp[n];
    }

    int choose = houseRobHelper(nums,n-2,dp)+ nums[n];
    int notChoose = houseRobHelper(nums,n-1,dp);

    return dp[n] = Math.max(choose,notChoose);


  }

  private int houseRobTab(int[] nums, int n, int[] dp){

    if(n > 0){
      dp[0] = nums[0];
    }

    if(n>1){
      dp[1] = Math.max(nums[0],nums[1]);
    }

    for (int i = 2; i < n; i++) {

      int choose = dp[i-2]+ nums[i];
      int notChoose = dp[i-1];
      dp[i] = Math.max(choose,notChoose);

    }

    return dp[n-1];


  }
}
