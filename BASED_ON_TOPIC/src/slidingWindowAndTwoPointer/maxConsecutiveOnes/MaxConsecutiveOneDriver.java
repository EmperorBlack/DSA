package slidingWindowAndTwoPointer.maxConsecutiveOnes;

public class MaxConsecutiveOneDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int longestOnes(int[] nums, int k) {

    int start = 0;
    int zeros = 0;
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {


      if(nums[i] == 0){
        zeros++;
      }

      while (zeros > k){
        if(nums[start] == 0){
          zeros--;
        }
        start++;
      }

      maxLength = Math.max(maxLength,i-start+1);

    }
    return maxLength;
  }
}