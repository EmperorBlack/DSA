package array.peakElement;

public class PeakELementDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int findPeakElement(int[] nums) {

    if(nums.length == 1){
      return 0;
    }
    if(nums[0] > nums[1]){
      return 0;
    }
    if(nums[nums.length-1] > nums[nums.length-2]){
      return nums.length-1;
    }

    return binarySearch(nums, 1, nums.length-2);
  }

  public int binarySearch(int nums[], int i, int j){

    if(i > j){
      return -1;
    }

    int mid = i + (j-i)/2;

    if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
      return mid;
    } else if (nums[mid] > nums[mid-1]) {
      return binarySearch(nums,mid+1, j);
    } else if (nums[mid] > nums[mid+1]) {
      return binarySearch( nums,i,mid-1);
    }else{
      return binarySearch( nums,i,mid-1);
    }

  }
}