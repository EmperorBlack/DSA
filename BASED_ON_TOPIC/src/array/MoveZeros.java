package array;

import java.util.Arrays;

public class MoveZeros {

  public static void main(String[] args) {
    new Solution2().moveZeroes(new int[]{1});
  }
}

class Solution2 {
  public void moveZeroes(int[] nums) {

    int i =-1;
    for(int j =0;j< nums.length;j++){

      if(nums[j] != 0){
        i++;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }

    System.out.println(Arrays.toString(nums));
  }
}

class Solution1 {
  public void moveZeroes(int[] nums) {

    int i =-1;
    for (int j = 0; j < nums.length; j++) {
      if(nums[j] ==0){
        i =j;
        break;
      }
    }
    if(i==-1){
      return;
    }
    int j = i+1;

    while (j< nums.length){

      if(nums[j] !=0){

        nums[i] = nums[j];
        nums[j] = 0;
        i++;
      }
      j++;
    }
  }
}