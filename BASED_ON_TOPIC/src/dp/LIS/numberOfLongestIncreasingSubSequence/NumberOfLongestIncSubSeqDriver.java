package dp.LIS.numberOfLongestIncreasingSubSequence;


import java.util.Arrays;

public class NumberOfLongestIncSubSeqDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().findNumberOfLIS(new int[]{2,2,2,2,2}));
  }
}



class Solution {
  public int findNumberOfLIS(int[] nums) {

    int[] dp = new int[nums.length];
    int[] counts = new int[nums.length];
    Arrays.fill(dp,1);
    Arrays.fill(counts,1);
    int max = 1;

    for (int i = 1; i < nums.length; i++) {

      for (int j = 0; j < i; j++) {

        if(nums[j] < nums[i]  ){

          if(dp[j]+1 > dp[i]){
            dp[i] = dp[j]+1;
            counts[i] = counts[j];
          } else if (dp[j]+1 == dp[i]) {
            counts[i] = counts[i]+counts[j];
          }

        }
      }
      max = Integer.max(dp[i],max);

    }

    int nois = 0;
    for (int i = 0; i < nums.length; i++) {
      if(dp[i] == max){
        nois += counts[i];
      }
    }


    return nois;

  }
}
