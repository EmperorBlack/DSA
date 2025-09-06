package google.BasicCalculatorTwo;

import java.util.Arrays;
import java.util.Stack;

public class BasicCalculatorTwoDriver {

  public static void main(String[] args) {
//    System.out.println(new Solution().calculate("3+2*2"));
//    int index = (int)Math.random() * ;
//    int sum = Arrays.stream(new int[]{1,2}).sum();
  }
}


class Solution {
  public int calculate(String s) {

    Stack<Integer> operands = new Stack<>();
    int num = 0;
    char operation = '+';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c == ' '){
        continue;
      }
      if(Character.isDigit(c)){
        num = num*10 + c-'0';
      }else{
        if(operation == '+'){
          operands.push(num);
        } else if (operation == '-') {
          operands.push(-num);
        } else if (operation == '*') {
          operands.push(operands.pop() * num);
        } else if (operation == '/') {
          operands.push(operands.pop() / num);
        }
        num =0;
        operation=c;

      }
    }
    if(operation == '+'){
      operands.push(num);
    } else if (operation == '-') {
      operands.push(-num);
    } else if (operation == '*') {
      operands.push(operands.pop() * num);
    } else if (operation == '/') {
      operands.push(operands.pop() / num);
    }

    int result = 0;
    while(!operands.isEmpty()){
      result += operands.pop();
    }

    return result;
  }
}















































//class Solution {
//  public int calculate(String s) {
//
//    String postFix = getPostFix(s);
//    Stack<Integer> stack = new Stack<>();
//
//    for (int i = 0; i < postFix.length(); i++) {
//
//      char c = postFix.charAt(i);
//      if(Character.isLetter(c) || Character.isDigit(c)){
//        stack.push(c - '0');
//      }else{
//
//        if(c == '+'){
//          int a = stack.pop();
//          int b = stack.pop();
//          stack.push(a + b);
//        } else if (c == '-') {
//          int a = stack.pop();
//          int b = stack.pop();
//          stack.push(b - a);
//        } else if (c == '*') {
//          int a = stack.pop();
//          int b = stack.pop();
//          stack.push(b * a);
//        }else{
//          int a = stack.pop();
//          int b = stack.pop();
//          if(a == 0){
//            throw new ArithmeticException("Division by zero");
//          }
//          stack.push(b / a);
//        }
//
//      }
//    }
//    return stack.pop();
//
//  }
//
//  private String getPostFix(String s){
//    StringBuilder result = new StringBuilder();
//    Stack<Character> operators = new Stack<>();
//
//
//    for (int i = 0; i < s.length(); i++) {
//      char c = s.charAt(i);
//      if(Character.isLetter(c) || Character.isDigit(c)){
//        result.append(c);
//      }else{
//        if(c == ' '){
//          continue;
//        }
//
//        while(!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)){
//          result.append(operators.pop());
//        }
//        operators.push(c);
//
//      }
//
//    }
//    while(!operators.isEmpty()){
//      result.append(operators.pop());
//    }
//    return result.toString();
//  }
//
//  private int precedence(char c) {
//    if(c == '+' || c == '-'){
//      return 1;
//    }else if(c == '*' || c == '/'){
//      return 2;
//    }
//    return -1;
//  }
//}
