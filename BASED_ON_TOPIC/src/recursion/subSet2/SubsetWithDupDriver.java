package recursion.subSet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDupDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    subsetsWithDup(nums,0,new ArrayList<>(),result);
    return result;

  }

  public void subsetsWithDup(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {


    result.add(new ArrayList<>(temp));

    for (int i = index; i < nums.length; i++) {
      if(i == index || nums[i] != nums[i-1]){
        temp.add(nums[i]);
        subsetsWithDup(nums,i+1,temp,result);
        temp.remove(temp.size()-1);
      }

    }

  }



}
