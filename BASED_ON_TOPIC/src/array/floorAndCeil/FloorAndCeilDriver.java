package array.floorAndCeil;

import java.util.Arrays;

public class FloorAndCeilDriver {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().getFloorAndCeil(73, new int[]{3,42})));
  }

}

class Solution {
  static int fIndex =-1,cIndex =-1;
  public int[] getFloorAndCeil(int x, int[] arr) {
    fIndex =-1;cIndex =-1;
    Arrays.sort(arr);
    findBSFloorSearch(arr,0,arr.length-1,x);
    return new int[]{fIndex == -1 ? -1 : arr[fIndex],cIndex == -1 ? -1 : arr[cIndex]};
  }


  static void findBSFloorSearch(int[] nums, int i, int j, int target) {
    // Base case
    if (i > j) {
      return; // Exit if indices cross
    }

    int mid = (i + j) / 2;

    // If we found an element equal to or less than target, update index
    if(nums[mid] == target){
      fIndex =cIndex = mid;
      return;
    }
    else if (nums[mid] < target) {
      fIndex = mid; // Update index to mid
      findBSFloorSearch(nums, mid + 1, j, target); // Search right for a potentially larger floor
    } else {
      cIndex = mid;
      findBSFloorSearch(nums, i, mid - 1, target); // Search left
    }
  }
}

