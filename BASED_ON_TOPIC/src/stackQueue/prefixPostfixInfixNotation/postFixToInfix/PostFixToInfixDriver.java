package stackQueue.prefixPostfixInfixNotation.postFixToInfix;

import java.util.Stack;

public class PostFixToInfixDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  static String postToInfix(String exp) {
    // code here

    Stack<String> stack = new Stack<>();
    int i =0;
    while (i < exp.length()){

      char c = exp.charAt(i);
      if(Character.isLetterOrDigit(c)){
        stack.push(String.valueOf(c));
      }else{
        String top = stack.pop();
        String ndTop = stack.pop();
        stack.push("("+ndTop+c+top+")");
      }
      i++;
    }
    return stack.pop();
  }
}