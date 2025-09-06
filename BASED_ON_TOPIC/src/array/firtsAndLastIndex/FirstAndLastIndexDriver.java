package array.firtsAndLastIndex;

import java.util.Arrays;

public class FirstAndLastIndexDriver {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(new Solution().searchRange(new int[]{2,2},2)));
  }
}

class Solution {
  public int[] searchRange(int[] nums, int target) {
    if(nums == null || nums.length == 0){
      return new int[]{-1,-1};
    }
    int index = bsSearch(nums,0,nums.length-1,target);

    int firstIndex = index;
    int lastIndex = index;

    if(index == -1){
      return new int[]{-1,-1};
    }
    while(firstIndex > 0  && nums[firstIndex] == nums[firstIndex-1]){
        firstIndex--;
    }

    while(lastIndex < nums.length-1 && nums[lastIndex] == nums[lastIndex+1]){
        lastIndex++;
    }
    return new int[]{firstIndex, lastIndex};




  }

  public int bsSearch(int[] nums,int i, int j, int target) {

    if(i > j){
      return -1;
    }

    int mid = i + (j-i)/2;
    if(nums[mid] == target){
      return mid;
    } else if (nums[mid] > target) {
      return bsSearch(nums,i,mid-1,target);
    }else{
      return bsSearch(nums,mid+1,j,target);
    }
  }
}
