package array.splitArrayLargestSum;

import java.util.Arrays;
import java.util.stream.Stream;

public class SplitArrayLargestSumDriver {

}

class Solution {
  public int splitArray(int[] nums, int k) {

    return getLargetsSum(getMax(nums),getSum(nums),nums,k);


  }

  private int getLargetsSum(int l, int r, int[] nums, int k){
    if(l > r){
      return l;
    }

    int mid = l+ (r-l)/2;
    int count = subArrCount(nums,mid);
    if(count <= k){
      return getLargetsSum(l,mid-1,nums,k);
    }else{
      return getLargetsSum(mid+1,r,nums,k);
    }


  }

  private int subArrCount(int[] nums, int maxValue){

    int count =1;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {

      if(sum+nums[i] > maxValue){
        count++;
        sum = nums[i];
      }else{
        sum = sum+nums[i];
      }
    }
    return count;
  }

  private int getMax(int[] nums){
    return Arrays.stream(nums).max().getAsInt();
  }

  private int getSum(int[] nums){
    return Arrays.stream(nums).sum();
  }
}
