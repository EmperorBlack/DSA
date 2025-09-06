package array.SingleNonDuplicateDriver;

public class SingleNonDuplicateDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
  }
}

class Solution {
  public int singleNonDuplicate(int[] nums) {

    if(nums.length == 1){
      return nums[0];
    }
    if(nums[0] != nums[1]){
      return nums[0];
    }
    if(nums[nums.length-1] != nums[nums.length-2]){
      return nums[nums.length-1];
    }
    return bsSearch(nums,1, nums.length-2);

  }

  public int bsSearch(int[] nums,int i, int j) {

    if(i > j){
      return -1;
    }

    int mid = (i+j)/2;
    if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
      return nums[mid];
    }

    if ((mid % 2 == 0 && nums[mid] != nums[mid+1]) || (mid % 2 == 1 && nums[mid] != nums[mid-1])) {
      return bsSearch(nums,i,mid-1);
    }else{
      return bsSearch(nums,mid+1,j);
    }
  }
}