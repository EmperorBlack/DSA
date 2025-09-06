package google.permutationTwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationTwoDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().permuteUnique(new int[]{1,1,2}));
  }
}

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {


    List<List<Integer>> result = new ArrayList<>();
    permuteHelp(nums,new HashSet<>(),new ArrayList<>(),result);
    return result;


  }

  private void permuteHelp(int[] nums, Set<Integer> set, List<Integer> sub, List<List<Integer>> result){

    if(sub.size() == nums.length){
      result.add(new ArrayList<>(sub));
      return;
    }

    for(int i =0; i<nums.length;i++){
      if(!set.contains(i)){
        if(i > 0 && nums[i] == nums[i-1] && !set.contains(i-1)){

          continue;
        }else{
          sub.add(nums[i]);
          set.add(i);
          permuteHelp(nums,set,sub,result);
          sub.remove(sub.size()-1);
          set.remove(i);
        }
      }
    }

  }
}