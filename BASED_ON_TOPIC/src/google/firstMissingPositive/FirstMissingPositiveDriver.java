package google.firstMissingPositive;

public class FirstMissingPositiveDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().firstMissingPositive(new int[]{
        1,1
    }));
  }
}


class Solution {
  public int firstMissingPositive(int[] nums) {


    for(int i =0; i< nums.length;i++){

      int num = nums[i];
      int swapIndex = num-1;

      while(swapIndex >=0 && swapIndex < nums.length && i != swapIndex && nums[i] != nums[swapIndex]){

        int temp = nums[swapIndex];
        nums[swapIndex] = num;
        nums[i] = temp;
        num = temp;
        swapIndex = num-1;
      }

      if(swapIndex < 0 || swapIndex >= nums.length){
        nums[i] = 0;
      }
    }

    for(int i=0;i< nums.length;i++){
      if(nums[i]-1 != i){
        return i+1;
      }
    }
    return nums.length+1;

  }
}