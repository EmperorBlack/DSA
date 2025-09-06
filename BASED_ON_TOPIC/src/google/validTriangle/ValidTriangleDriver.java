package google.validTriangle;

import java.util.Arrays;

public class ValidTriangleDriver {

  public static void main(String[] args) {

    System.out.println(new Solution_2().triangleNumber(new int[]{2,2,3,4}));
  }
}


class Solution {
  public int triangleNumber(int[] nums) {

    int count =0;
    for(int i =0;i< nums.length;i++){
      for(int j =i+1;j < nums.length;j++){
        for(int k =j+1;k< nums.length;k++){
          if(nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i]){
            count++;
          }

        }
      }
    }
    return count;
  }
}

class Solution_2 {
  public int triangleNumber(int[] nums) {

    int count = 0;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {

      for (int j = i+1; j < nums.length; j++) {

        int left = j + 1;
        int right = nums.length-1;
        // Binary search for the third side of the triangle
        int target = nums[i] + nums[j];

        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (target > nums[mid]) {
            left = mid + 1; // move to the right side
          } else {
            right = mid-1; // move to the left side
          }
        }

        count += (left - j-1 );

      }

    }
    return count;
  }
}