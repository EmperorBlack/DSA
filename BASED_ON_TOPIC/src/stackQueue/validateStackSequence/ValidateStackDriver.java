package stackQueue.validateStackSequence;

import java.util.Stack;

public class ValidateStackDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
  }
}


class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {

    Stack<Integer> stack = new Stack<>();
    int poIndex =0;
   for (int push : pushed){

     stack.push(push);

     while (!stack.isEmpty() && stack.peek() == popped[poIndex] ){
       stack.pop();
       poIndex++;
     }
   }

   return stack.isEmpty();


  }
}
