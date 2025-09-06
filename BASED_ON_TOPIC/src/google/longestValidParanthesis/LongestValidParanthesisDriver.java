package google.longestValidParanthesis;

import java.util.Stack;

public class LongestValidParanthesisDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().longestValidParentheses(")()())"));
  }
}

//Using stack



class Solution {
  public int longestValidParentheses(String s) {

    Stack<Integer> stack = new Stack<>();
    stack.push(-1);

    for (int i = 0; i < s.length(); i++) {
      if(stack.peek()!= -1 && s.charAt(i) == ')' && s.charAt(stack.peek())== '('){
        stack.pop();
      }else{
        stack.push(i);
      }
    }


      int top = s.length();
      int maxLength = Integer.MIN_VALUE;
      while (!stack.isEmpty()){

        maxLength = Math.max(top-stack.peek(), maxLength);
        top = stack.pop();
      }



    return maxLength-1;

  }


}