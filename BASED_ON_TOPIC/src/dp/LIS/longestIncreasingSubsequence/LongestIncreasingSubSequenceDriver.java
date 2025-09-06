package dp.LIS.longestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubSequenceDriver {

  public static void main(String[] args) {

    System.out.println(new Solution_BS().lengthOfLIS(new int[]{2,4,3,6}));
  }
}

class Solution {
  public int lengthOfLIS(int[] nums) {

    int[][] dp = new int[nums.length][nums.length+1];
//    for (int i = 0; i < nums.length; i++) {
//      Arrays.fill(dp[i],-1);
//    }
//    return lengthOfLisHelper(nums, nums.length-1, dp,nums.length);

    for (int i = 0; i < nums.length+1; i++) {

      if(i == nums.length || nums[0] < nums[i]){
        dp[0][i] = 1;
      }
    }

    for (int i = 1; i < nums.length; i++) {
      for (int last = 1; last < nums.length+1; last++) {

        int take = 0;
        if(last == nums.length || nums[i] < nums[last]){
          take = dp[i-1][i]+1;
        }
        int notTake = dp[i-1][last];
        dp[i][last] = Integer.max(take,notTake);
      }
    }

    return dp[nums.length-1][nums.length];
  }

  private int lengthOfLisHelper(int[] nums, int i , int[][] dp, int last){


//    if(i == 0){
//      if(nums.length == last || nums[i] < nums[last]){
//        return 1;
//      }
//      return 0;
//    }
    if(i < 0){
      return 0;
    }

    if(dp[i][last] != -1){
      return dp[i][last];
    }

    int take = 0;
    if(last == nums.length || nums[i] < nums[last]){
      take = lengthOfLisHelper(nums,i-1,dp,i)+1;
    }
    int notTake = lengthOfLisHelper(nums,i-1,dp,last);

    return dp[i][last] = Integer.max(take,notTake);
  }
}

class Solution_2 {
  public int lengthOfLIS(int[] nums) {


    int[] dp = new int[nums.length];
    Arrays.fill(dp,1);

    int max = 1;
    for (int i = 0; i < nums.length; i++) {

      for (int j = 0; j < i; j++) {

        if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
          dp[i] = dp[j]+1;
          max = Math.max(max, dp[i]);

        }
      }
    }

    return max;


  }
}

class Solution_BS {
  public int lengthOfLIS(int[] nums) {

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {



      int pos = BS(list,nums[i],0,list.size()-1);
      if(list.size() <= pos){
        list.add(nums[i]);
      }else{
        list.set(pos,nums[i]);
      }
    }



    return list.size();
  }

  private int BS(List<Integer> list, int num, int l ,int r){

    if(l>r){
      return l;
    }

    int mid = l + (r-l)/2;

    if(list.get(mid) > num){
      return BS(list,num,l ,mid-1);
    } else if (list.get(mid) < num) {
      return BS(list,num,mid+1 ,r);
    }else{
      return mid;
    }


  }
}

class Solution_CBS {
  public int lengthOfLIS(int[] nums) {
    List<Integer> list = new ArrayList<>();

    for (int num : nums) {
      int pos = Collections.binarySearch(list, num);

      if (pos < 0) {
        pos = -pos - 1;
      }

      if (pos == list.size()) {
        list.add(num);
      } else {
        list.set(pos, num);
      }
    }

    return list.size();
  }
}
