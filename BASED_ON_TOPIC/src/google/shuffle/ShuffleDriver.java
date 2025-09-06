package google.shuffle;

import java.util.Random;

public class ShuffleDriver {

  public static void main(String[] args) {



  }
}




class Solution {

  private int[] original;
  private int[] nums;
  private Random rand;

  public Solution(int[] nums) {
    this.original = nums.clone(); // store original
    this.nums = nums.clone();     // working copy
    this.rand = new Random();     // use Random instead of Math.random()
  }

  public int[] reset() {
    nums = original.clone();      // reset working copy
    return nums;
  }

  public int[] shuffle() {
    for (int i = 0; i < nums.length; i++) {
      int j = i + rand.nextInt(nums.length - i); // random index from i to n-1
      // swap nums[i] and nums[j]
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
    return nums;
  }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */