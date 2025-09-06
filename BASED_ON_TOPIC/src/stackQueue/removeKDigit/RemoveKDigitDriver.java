package stackQueue.removeKDigit;

import java.util.Stack;

public class RemoveKDigitDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().removeKdigits("10",2));
  }
}


class Solution {
  public String removeKdigits(String num, int k) {

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < num.length(); i++) {

      while (!stack.isEmpty() && stack.peek() > Character.getNumericValue(num.charAt(i)) && k > 0){
        stack.pop();
        k--;
      }
      stack.push(Character.getNumericValue(num.charAt(i)));

    }

    while (k > 0){
      stack.pop();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()){
      sb.append(stack.pop());
    }
    sb = sb.reverse();
    while (!sb.isEmpty() && sb.charAt(0) == '0'){
      sb.deleteCharAt(0);
    }

    return sb.toString().isEmpty() ? "0" : sb.toString();
  }
}