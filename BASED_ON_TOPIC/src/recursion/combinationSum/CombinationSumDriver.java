package recursion.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().combinationSum(new int[]{2,3,6,7},7));
  }

}

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList[][] dp = new ArrayList[candidates.length][target+1];
    List<List<Integer>> result = new ArrayList<>();
    combinationSumHelper(candidates,target, candidates.length-1,new ArrayList<>(),result );
    return result;
  }

  public void combinationSumHelper(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> result) {

    if(target < 0 || index < 0){
      return;
    }

    if (target == 0){
      result.add(new ArrayList<>(temp));
      return;
    }



    if(candidates[index] <= target){
      temp.add(candidates[index]);
      combinationSumHelper(candidates,target-candidates[index],index,temp,result);
      temp.remove(temp.size()-1);
    }
    combinationSumHelper(candidates,target,index-1,temp,result);


  }
}
