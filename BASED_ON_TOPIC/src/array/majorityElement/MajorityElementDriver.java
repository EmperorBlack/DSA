package array.majorityElement;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementDriver {



}


class Solution {
  public List<Integer> majorityElement(int[] nums) {

    int count1 =0;
    int count2 =0;
    int candidate1=Integer.MAX_VALUE;
    int candidate2=Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {

      if(count1 == 0 && nums[i] != candidate2){

        candidate1 = nums[i];
        count1++;
      } else if (count2 ==0 && candidate1 != nums[i]) {
        candidate2 = nums[i];
        count2++;
      } else if (nums[i] == candidate1) {
        count1++;
      } else if (nums[i] == candidate2) {
        count2++;
      }else {
        count1--;
        count2--;
      }
    }

    int thresold = nums.length/3;
    int num1Count =0;
    int num2Count =0;
    for (int i = 0; i <nums.length ; i++) {

      if(nums[i] == candidate1)
        num1Count++;

      if(nums[i] == candidate2)
        num2Count++;
    }
    List<Integer> list = new ArrayList<>();
    if(num1Count > thresold){
      list.add(candidate1);
    }
    if(num2Count > thresold){
      list.add(candidate2);
    }
    return list;
  }
}