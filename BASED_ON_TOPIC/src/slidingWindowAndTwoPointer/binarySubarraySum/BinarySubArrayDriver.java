package slidingWindowAndTwoPointer.binarySubarraySum;

public class BinarySubArrayDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().numSubarraysWithSum(new int[]{0,1,1,1,1},3));
  }
}


class Solution {
  public int numSubarraysWithSum(int[] nums, int goal) {

    return numSubarraysWithSumHelper(nums,goal)-numSubarraysWithSumHelper(nums,goal-1);
  }

//   we are checking for less than equals goal because 0 is creating problem
  public int numSubarraysWithSumHelper(int[] nums, int goal) {

    int l =0,r=0,sum=0,count =0;
    if(goal < 0){return 0;}

    while(r < nums.length){
      sum = sum+ nums[r];

      while (sum > goal){
        sum = sum-nums[l];
        l++;
      }
      count = count + (r-l+1);

      r = r+1;
    }
    return count;
  }
}