package dp.LIS.largestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisiableSubsetDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {


    int[] dp = new int[nums.length];
    int[] indexes = new int[nums.length];
    Arrays.sort(nums);
    Arrays.fill(dp,1);
    Arrays.fill(indexes,-1);


    int max = 1;
    int maxIndex = 0;
    for (int i = 1; i < nums.length; i++) {

      for (int j = 0; j < i; j++) {

        if((nums[i] % nums[j] == 0 || nums[j] %nums[i] ==0) && dp[j]+1 > dp[i]){
          dp[i] = dp[j]+1;
          indexes[i] = j;
          if(dp[i] > max){
            max = dp[i];
            maxIndex = i;
          }
        }

      }
    }

    List<Integer> result = new ArrayList<>();

    while (maxIndex >= 0){

      result.add(0,nums[maxIndex]);
      maxIndex = indexes[maxIndex];
    }
    return result;

  }
}
