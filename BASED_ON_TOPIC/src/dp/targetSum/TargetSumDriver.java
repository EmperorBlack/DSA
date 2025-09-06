package dp.targetSum;

import java.util.HashMap;
import java.util.Map;

public class TargetSumDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().findTargetSumWays(new int[]{100,100},100));
  }
}

class Solution {
  public int findTargetSumWays(int[] nums, int target) {

    Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
    return findTargetSumHelper(nums,nums.length-1,target,map);


  }

  private int findTargetSumHelper(int[] nums, int index, int target, Map<Integer, Map<Integer,Integer>> dp){

    if(index == 0){
      if(target == 0 && nums[0] ==0){
        return 2;
      }
      if((target - nums[0]) ==0 || target + nums[0] == 0){
        return 1;
      }
      return 0;
    }

    if(dp.get(index) != null && dp.get(index).get(target) != null){
      return dp.get(index).get(target);
    }

    int minus = findTargetSumHelper(nums,index-1,target-nums[index],dp);
    int plus = findTargetSumHelper(nums,index-1,target+nums[index],dp);


    int total = plus+minus;
    Map<Integer,Integer> inner = dp.getOrDefault(index,new HashMap<>());
    inner.put(target,inner.getOrDefault(target,0)+total);
    return total;


  }
}