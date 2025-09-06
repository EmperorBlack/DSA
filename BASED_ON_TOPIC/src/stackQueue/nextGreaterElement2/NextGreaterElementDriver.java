package stackQueue.nextGreaterElement2;

import java.util.Stack;

public class NextGreaterElementDriver {

}

class Solution {
  public int[] nextGreaterElements(int[] nums) {

    Stack<Integer> stack = new Stack<>();
    int[] result = new int[nums.length];

    for (int i = nums.length-1; i >=0 ; i--) {
//      while (!stack.isEmpty() && stack.peek() <= nums[i]){
//        stack.pop();
//      } Not required
      stack.push(nums[i]);
    }

    for (int i = nums.length-1; i >=0 ; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i]){
        stack.pop();
      }
      if(stack.isEmpty()){
        result[i] = -1;
      }else{
        result[i] = stack.peek();
      }
      stack.push(nums[i]);
    }

    return result;
  }
}
