package bitManipulation.powerSetBit;

import java.util.ArrayList;
import java.util.List;

public class PowerSetDriver {

  public static void main(String[] args) {
    System.out.println(Solution.subsets(new int[]{1,2,3}));
  }
}

class Solution {

  public static List<List<Integer>> subsets(int[] nums) {

    int n =  (1 << nums.length)-1;

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      List<Integer> sub = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {

        if(((i>>j) & 1) == 1){
          sub.add(nums[j]);
        }

      }
      result.add(sub);

    }
    return result;


  }
}

