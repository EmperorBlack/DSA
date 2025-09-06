package array.SubarrayWithSumK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().subarraySum(new int[]{1,2,3},3));
  }
}


class Solution {
  public int lenOfLongestSubarr(int[] arr, int k) {
    // code here

    Map<Long,Integer> map = new HashMap<>();
    map.put(0L,-1);

    long subArraySum = 0;
    int maxLen = 0;
    for (int i = 0; i < arr.length; i++) {

      subArraySum = subArraySum + arr[i];
      if(map.containsKey(subArraySum-k)){

        if((i-map.get(subArraySum-k)) > maxLen){
          maxLen = i-map.get(subArraySum-k);
        }
      }

      if (!map.containsKey(subArraySum)) {
        map.put(subArraySum, i);
      }

    }
    return maxLen;

  }

  public int subarraySum(int[] arr, int k) {
    Map<Integer,Integer> map = new HashMap<>();

    int subArraySum = 0;
    int count =0;
    map.put(0,1);
    for (int i = 0; i < arr.length; i++) {

      subArraySum += + arr[i];
      if(map.containsKey(subArraySum-k)){
        count += map.get(subArraySum-k);
      }
      map.put(subArraySum, map.getOrDefault(subArraySum,0) + 1);
    }
    return count;
  }
}

