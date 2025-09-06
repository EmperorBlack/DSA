package array.contigousArray;

import java.util.HashMap;
import java.util.Map;

public class ContigousArrayDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().findMaxLength(new int[]{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));

  }
}

class Solution {
  public int findMaxLength(int[] nums) {

    Map<Integer, Integer> map= new HashMap<>();
    map.put(0,-1);

    int sum =0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] == 1){
        sum++;
      }else{
        sum--;
      }

      if(map.containsKey(sum)){
        max = Math.max(max,i-(sum));
      }else{
        map.put(sum, i);
      }

    }
    return max;


  }
}
