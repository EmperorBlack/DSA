package slidingWindowAndTwoPointer.subArrayWithKdiferentInt;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentIntDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int subarraysWithKDistinct(int[] nums, int k) {

    return subarraysWithKDistinctHelp(nums,k)- subarraysWithKDistinctHelp(nums,k-1);


  }
  public int subarraysWithKDistinctHelp(int[] nums, int k) {

    int l =0,r=0;
    Map<Integer,Integer> map = new HashMap<>();
    int count = 0;
    if(k < 0){
      return 0;
    }
    while (r < nums.length){

      map.put(nums[r],map.getOrDefault(nums[r],0)+1);

      while (map.size() > k){
        map.put(nums[l], map.get(nums[l])-1);
        if(map.get(nums[l]) ==0 ){
          map.remove(nums[l]);
        }
        l++;
      }
      count = count + r-l+1;
     r++;

    }

    return count;


  }

}
