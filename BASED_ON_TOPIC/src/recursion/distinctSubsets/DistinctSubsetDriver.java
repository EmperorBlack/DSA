package recursion.distinctSubsets;

import java.util.ArrayList;
import java.util.List;

public class DistinctSubsetDriver {

  public static void main(String[] args) {

  }
}

class Solution {

  public static List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    subsets(nums,0,new ArrayList<>(),result);

    return result;
  }

  public static void subsets(int[] nums, int start,List<Integer> temp, List<List<Integer>> result) {


   result.add(new ArrayList<>(temp));
    for (int i = start; i < nums.length; i++) {
      if(i==0 || nums[i]!= nums[i-1]){
        temp.add(nums[i]);
        subsets(nums,i+1,temp,result);
        temp.remove(temp.size()-1);
      }
    }
  }
}
