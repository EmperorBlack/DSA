package array.maxprodSubArrLen;

public class MaxProductSubArrLenDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().getMaxLen(new int[]{5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2}));
  }
}


class Solution {
  public int getMaxLen(int[] nums) {

    int max = 0;
    int start = -1;
    double prod =1;

    for (int i = 0; i < nums.length; i++) {

      if(nums[i] ==0){
        start = i;
        prod = 1;
      }else{
        prod = prod*nums[i];
        if(prod > 0){
          max = Integer.max(i-start,max);
        }
      }
    }

    start = nums.length;
    prod = 1;
    for (int i = nums.length-1; i >=0 ; i--) {

      if(nums[i] == 0){
        start = i;
        prod = 1;
      }else{
        prod = prod * nums[i];
        if(prod > 0){
          max = Math.max(max,start-i);
        }

      }
    }
    return max;


  }
}