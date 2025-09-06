package array.maxPuductSubArray;

public class MaxProductSubArrayDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().maxProduct(new int[]{-2,-0,-1}));

  }

}

class Solution {
  public int maxProduct(int[] nums) {


    long prefix = 1;
    long suffix = 1;

    long maxProduct = Integer.MIN_VALUE;

    for(int i =0;i< nums.length ; i++){

      prefix = prefix * nums[i];
      suffix = suffix * nums[nums.length-i-1];
      maxProduct = Math.max(maxProduct,Math.max(prefix,suffix));
      if(nums[i] ==0) {
        prefix = 1;
      }
      if(nums[nums.length-i-1] ==0) {
        suffix = 1;
      }

    }

    return (int)maxProduct;
  }
}