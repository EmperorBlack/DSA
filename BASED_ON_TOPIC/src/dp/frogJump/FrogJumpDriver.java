package dp.frogJump;

import java.util.Arrays;

public class FrogJumpDriver {

  public static void main(String[] args) {

    System.out.println(Solution.frogJump(4,new int[]{10 ,20 ,30 ,10}));
  }
}

class Solution {
  public static int frogJump(int n, int heights[]) {

    int[] dp = new int[n];
    Arrays.fill(dp,-1);
    // Write your code here..
    return calMinEnergy(n-1,heights,dp);
  }

  public static int calMinEnergy(int n, int[] heights, int[] dp){

    if(n == 0 ){
      return 0;
    }

    if(n == 1) {
      return Math.abs(heights[n]-heights[0]);
    }

    if(dp[n] != -1){
      return dp[n];
    }

    int left = calMinEnergy(n-1,heights,dp) + Math.abs(heights[n]-heights[n-1]);
    int right = calMinEnergy(n-2,heights,dp) + Math.abs(heights[n]-heights[n-2]);

    return dp[n] = Math.min(left,right);


  }

}

