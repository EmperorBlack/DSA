package stackQueue.sumOfSubarrayMinimum;

import java.util.Stack;

public class SumOfSubArrayDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().sumSubarrayMins(new int[]{3,1,2,4}));

  }
}

class Solution {
//  if 3 on right and 4 on left total number of subarray will be 3*4
//  [1,1] dont consider there is four subarray actually 4 subarray, but we will consider 3 as
//  2nd one is contributed in first one's subarray
//  we need to adjust one of nse of pse to read till next small not next or previous small or equals;
  public int sumSubarrayMins(int[] arr) {

    int mod = 1000000007;
   int[] preSmall = new int[arr.length];
   int[] nextSmall = new int[arr.length];
   Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++) {

      while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
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
    for (int i = arr.length-1; i >= 0; i--) {

      while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
        stack.pop();
      }
      if(stack.isEmpty()){
        nextSmall[i] = arr.length;
      }else{
        nextSmall[i] = stack.peek();
      }
      stack.push(i);
    }

    long sum = 0;
    for (int i = 0; i < arr.length; i++) {

      long mul = (arr[i]* ((long) (nextSmall[i] - i) *(i-preSmall[i])))%mod;

      sum = (sum + mul)%mod;
    }

    return (int) sum;
  }
}
