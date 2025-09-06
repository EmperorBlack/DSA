package recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class SubSetsDriver {

  public static void main(String[] args) {

  }

}

class Solution {
  public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    subsets(nums,0,new ArrayList<>(),result);

    return result;
  }

  public void subsets(int[] nums, int index,List<Integer> temp, List<List<Integer>> result) {


    if(index == nums.length){
      result.add(new ArrayList<>(temp));
      return;
    }

    temp.add(nums[index]);
    subsets(nums,index+1,temp,result);
    temp.remove(temp.size()-1);
    subsets(nums,index+1,temp,result);
  }
}