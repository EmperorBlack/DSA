package stackQueue.prefixPostfixInfixNotation.postFixToPrefix;

import java.util.Stack;

public class PostFixToPrefixDriver {

}

class Solution {
  static String postToPre(String post_exp) {

    Stack<String> stack = new Stack<>();

    for (int i = 0; i < post_exp.length(); i++) {
      char c = post_exp.charAt(i);

      if(Character.isLetterOrDigit(c)){
        stack.push(String.valueOf(c));
      }else{
        String top = stack.pop();
        String ndTop = stack.pop();
        stack.push(c+ndTop+top);
      }

    }
    return stack.pop();
  }
}