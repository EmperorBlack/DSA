package array.nextPermutation;

public class NextPermutationDriver {

  public static void main(String[] args) {

    new Solution().nextPermutation(new int[]{1,2,3});
  }

}


class Solution {
  public void nextPermutation(int[] nums) {

    if(nums.length < 1){
      return;
    }

    int i = nums.length-1;
    while (i > 0){

      if(nums[i] > nums[i-1]){
        break;
      }
      i--;
    }
    int k =i-1;
    if(i == 0){
      reversePosition(i, nums.length-1,nums );
      return;
    }
    for (int j = nums.length-1; j>k; j--) {
      if(nums[j] > nums[k]){
        int temp = nums[k];
        nums[k] = nums[j];
        nums[j] = temp;
        break;
      }
    }
    reversePosition(i, nums.length-1,nums );

  }

  public void reversePosition(int i , int j, int[] nums){

    while (i<j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }
}