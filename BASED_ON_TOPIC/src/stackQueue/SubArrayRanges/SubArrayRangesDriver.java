package stackQueue.SubArrayRanges;

import java.util.Stack;

public class SubArrayRangesDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().subArrayRanges(new int[]{1,2,3}));
  }
}


class Solution {
  public long subArrayRanges(int[] nums) {

    int[] preSmall = new int[nums.length];
    int[] nextSmall = new int[nums.length];
    int[] preBig = new int[nums.length];
    int[] nextBig = new int[nums.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < nums.length; i++) {

      while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
        stack.pop();
      }
      if(stack.isEmpty()){
        preSmall[i] = -1;
      }else{
        preSmall[i] = stack.peek();
      }
      stack.push(i);
    }

    stack.clear();
    for (int i = nums.length-1; i >= 0; i--) {

      while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
        stack.pop();
      }
      if(stack.isEmpty()){
        nextSmall[i] = nums.length;
      }else{
        nextSmall[i] = stack.peek();
      }
      stack.push(i);
    }

    stack.clear();
    for (int i = 0; i < nums.length; i++) {

      while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
        stack.pop();
      }
      if(stack.isEmpty()){
        preBig[i] = -1;
      }else{
        preBig[i] = stack.peek();
      }
      stack.push(i);
    }

    stack.clear();
    for (int i = nums.length-1; i >= 0; i--) {

      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
        stack.pop();
      }
      if(stack.isEmpty()){
        nextBig[i] = nums.length;
      }else{
        nextBig[i] = stack.peek();
      }
      stack.push(i);
    }


    long sumLess = 0;
    for (int i = 0; i < nums.length; i++) {

      long mul = (nums[i]* ((long) (nextSmall[i] - i) *(i-preSmall[i])));

      sumLess = (sumLess + mul);
    }

    long sumBig = 0;
    for (int i = 0; i < nums.length; i++) {

      long mul = (nums[i]* ((long) (nextBig[i] - i) *(i-preBig[i])));

      sumBig = (sumBig + mul);
    }

    return (sumBig- sumLess);
  }
}