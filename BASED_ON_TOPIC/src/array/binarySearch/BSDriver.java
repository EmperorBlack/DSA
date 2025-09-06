package array.binarySearch;

import java.util.Arrays;

public class BSDriver {

  public static void main(String[] args) {

  }

}

class Solution {
  public int search(int[] nums, int target) {


    return bsSearch(nums,0, nums.length-1,target );


  }

  public int bsSearch(int[] nums,int i, int j, int target) {

    if(i > j){
      return -1;
    }

    int mid = (i+j)/2;
    if(nums[mid] == target){
      return mid;
    } else if (nums[mid] > target) {
      return bsSearch(nums,i,mid-1,target);
    }else{
      return bsSearch(nums,mid+1,j,target);
    }
  }

  static int index =0;
  static int findFloor(int[] arr, int k) {
    index = 0;
    findBSFloorSearch(arr,0, arr.length-1,k );
    return index;
  }
  static void findBSFloorSearch(int[] nums,int i, int j, int target) {
    if(i > j){
      return;
    }

    int mid = (i+j)/2;
   if (nums[mid] >= target) {
      index = mid;
     findBSFloorSearch(nums,i,mid-1,target);
    }else{
     findBSFloorSearch(nums,mid+1,j,target);
    }
  }

}
