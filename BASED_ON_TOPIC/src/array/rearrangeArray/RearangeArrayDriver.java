package array.rearrangeArray;

import java.util.ArrayList;
import java.util.List;

public class RearangeArrayDriver {

  public static void main(String[] args) {

  }

}

class Solution {
  public int[] rearrangeArray(int[] nums) {

    List<Integer> positive = new ArrayList<>();
    List<Integer> negative = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {

      if(nums[i] >= 0){
        positive.add(nums[i]);
      }else{
        negative.add(nums[i]);
      }
    }
    int i =0;
    int j =0;
    while (i < positive.size()){

      nums[j++] = positive.get(i);
      nums[j++] = negative.get(i++);
    }
    return nums;
  }
}

class Solution2 {
  public int[] rearrangeArray(int[] nums) {

   int res[] = new int[nums.length];
   int j = 0;
   int k = 1;

    for (int i = 0; i < nums.length; i++) {

      if(nums[i] >= 0){
        res[j] = nums[i];
        j= j+2;
      }else{
        res[k]= nums[i];
        k= k+2;
      }
    }
    return res;
  }
}