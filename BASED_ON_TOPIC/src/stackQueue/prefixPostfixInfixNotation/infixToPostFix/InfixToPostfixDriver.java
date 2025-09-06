package stackQueue.prefixPostfixInfixNotation.infixToPostFix;

import java.util.Stack;

public class InfixToPostfixDriver {

  public static void main(String[] args) {
    System.out.println(Solution.infixToPostfix("x+y*z/w+u"));
  }
}

class Solution {
  // Function to convert an infix expression to a postfix expression.
  public static String infixToPostfix(String s) {
    // Your code here

    StringBuilder ans = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {

      if(Character.isLetterOrDigit(s.charAt(i))){
        ans.append(s.charAt(i));
      } else if (s.charAt(i) == '(') {
        stack.push('(');
      } else if (s.charAt(i) == ')') {
        while (!stack.isEmpty() && stack.peek() != '('){
          ans.append(stack.pop());
        }
        stack.pop();
      }else {

        while(!stack.isEmpty() && getPrecedence(s.charAt(i)) <= getPrecedence(stack.peek())){
          ans.append(stack.pop());
        }
        stack.push(s.charAt(i));
      }

    }

    while (!stack.isEmpty()){
      ans.append(stack.pop());
    }
    return ans.toString();

  }

  private static int getPrecedence(char c){

    switch (c) {
      case '^':
        return 3;
      case '*':
      case '/':
        return 2;
      case '+':
      case '-':
        return 1;
      default:
        return -1;
    }
  }
}