package stackQueue.prefixPostfixInfixNotation.prefixToinfix;

import java.util.Stack;

public class PrefixToInfixDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  static String preToInfix(String exp) {
    // code here

    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder(exp);
    exp = sb.reverse().toString();
    int i =0;
    while (i < exp.length()){

      char c = exp.charAt(i);
      if(Character.isLetterOrDigit(c)){
        stack.push(String.valueOf(c));
      }else{
        String top = stack.pop();
        String ndTop = stack.pop();
        stack.push(")"+ndTop+c+top+"(");
      }
      i++;
    }
    return new StringBuilder(stack.pop()).reverse().toString();
  }
}


class Solution_2 {
  static String preToInfix(String exp) {
    // code here

    Stack<String> stack = new Stack<>();
    int i = exp.length()-1;
    while (i >=0 ){

      char c = exp.charAt(i);
      if(Character.isLetterOrDigit(c)){
        stack.push(String.valueOf(c));
      }else{
        String top = stack.pop();
        String ndTop = stack.pop();
        stack.push("("+top+c+ndTop+")");
      }
      i--;
    }
    return stack.peek();
  }
}