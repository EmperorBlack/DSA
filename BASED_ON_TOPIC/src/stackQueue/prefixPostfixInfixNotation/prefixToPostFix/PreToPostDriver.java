package stackQueue.prefixPostfixInfixNotation.prefixToPostFix;

import java.util.Stack;

public class PreToPostDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  static String preToPost(String pre_exp) {
    Stack<String> stack = new Stack<>();

    for (int i = pre_exp.length()-1; i >= 0; i--) {
      char c = pre_exp.charAt(i);

      if(Character.isLetterOrDigit(c)){
        stack.push(String.valueOf(c));
      }else{
        String top = stack.pop();
        String ndTop = stack.pop();
        stack.push(top+ndTop+c);
      }

    }
    return stack.pop();
  }
}