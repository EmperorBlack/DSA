package array.sortColor;

public class SortColorDriver {

}

class Solution {
  public void sortColors(int[] nums) {

    int i =0,k=0,j= nums.length-1;

    while(k<=j){

      if(nums[k] == 2){
        swap(k,j,nums);
        j--;
      } else if (nums[k] == 0) {
        swap(k,i,nums);
        k++;
        i++;
      }else{
        k++;
      }

    }

  }

  public void swap(int i, int j,int[] nums){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
