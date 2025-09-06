package slidingWindowAndTwoPointer.countNiceSubarray;

public class CountNiceSubArrayDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int numberOfSubarrays(int[] nums, int k) {

    return numSubarraysWithSumHelper(nums,k)-numSubarraysWithSumHelper(nums,k-1);
  }
//  converting it to binary subarraySUm by replaing oddNumber to 1 and event number to zero
  public int numSubarraysWithSumHelper(int[] nums, int goal) {

    int l =0,r=0,sum=0,count =0;
    if(goal < 0){return 0;}

    while(r < nums.length){
      sum = sum + (nums[r]%2);

      while (sum > goal){
        sum = sum-(nums[l]%2);
        l++;
      }
      count = count + (r-l+1);

      r = r+1;
    }
    return count;
  }
}
