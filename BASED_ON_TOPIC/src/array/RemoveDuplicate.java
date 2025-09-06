package array;

public class RemoveDuplicate {

  public static void main(String[] args) {

  }

}
class Solution {
  public int removeDuplicates(int[] nums) {

    if(nums.length < 2){
      return nums.length;
    }
    int i=0,j=1;
    while (j < nums.length) {
      if(nums[i] == nums[j]){
        j++;
      }else{
        nums[++i] = nums[j++];
      }
    }
    return i+1;

  }
}