package recursion.combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2Driver {

  public static void main(String[] args) {

  }
}

class Solution {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    combinationSumHelp(candidates, target, 0, new ArrayList<>(), result);
    return result;


  }

  public void combinationSumHelp(int[] candidates, int target, int start, List<Integer> temp,
      List<List<Integer>> result) {

    if (target < 0) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(temp));
    }

    for (int i = start; i < candidates.length; i++) {
      if (i == start || candidates[i] != candidates[i - 1]) {
        temp.add(candidates[i]);
        combinationSumHelp(candidates, target - candidates[i], i + 1, temp, result);
        temp.remove(temp.size() - 1);
      }


    }


  }


}
