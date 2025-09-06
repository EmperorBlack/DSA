package google.MinMaxDifferencePair;

import java.util.Arrays;

public class MinMaxDiffPairDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minimizeMax(new int[]{10,1,2,7,1,3},2));
  }
}

class Solution {
  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums);
    int l =0;
    int r = nums[nums.length-1] - nums[0];

    while(l<=r){
      int mid = l+ (r-l)/2;
      if(isFit(nums, p, mid)){
        r = mid-1;
      }else{
        l = mid+1;
      }
    }
    return l;
  }

  private boolean isFit(int[] nums, int p, int diff){

    int k =0;
    for(int i =1;i< nums.length;i++){

      if(nums[i] - nums[i-1] <= diff){
        i++;
        k++;
      }
    }
    return k >= p;

  }
}
