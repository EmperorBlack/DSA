package array.searchInRotatedSort;

public class SearchInRotatedSortDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[]{},4));
  }
}

class Solution {
  public int search(int[] nums, int target) {
    return bsSearch(nums,0, nums.length -1,target);
  }

  public int bsSearch(int[] nums,int i, int j, int target) {

    if(i > j){
      return -1;
    }

    int mid = (i+j)/2;

    if(nums[mid] == target){
      return mid;
    } else if (nums[mid] >= nums[i]) {
      if(nums[mid] > target && nums[i] <= target){
        return bsSearch(nums,i,mid-1,target);
      }else{
        return bsSearch(nums,mid+1,j,target);
      }
    }else{
      if(nums[mid] < target && nums[j] >= target){
        return bsSearch(nums,mid+1,j,target);
      }else{
        return bsSearch(nums,i,mid-1,target);
      }
    }
  }
}


