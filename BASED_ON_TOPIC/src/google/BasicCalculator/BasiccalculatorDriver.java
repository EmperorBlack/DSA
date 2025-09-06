package google.BasicCalculator;

import java.util.Stack;

public class BasiccalculatorDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
  }
}


class Solution {
  public int calculate(String s) {

    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int number =0;
    int sign = +1;


    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);

      if(Character.isDigit(c)){

        number = (10 * number) + Character.getNumericValue(c);

      } else if (c == '+') {
        result = result + (number * sign);
        number =0;
        sign = +1;

      }else if (c == '-') {
        result = result + (number * sign);
        number =0;
        sign = -1;
      } else if (c == '(') {

        stack.push(result);
        stack.push(sign);

        number =0;
        result =0;
        sign = 1;

      } else if (c == ')') {
        result = result + (number*sign);
        number = 0;

        Integer stckSign = stack.pop();
        Integer lastResult = stack.pop();

        result = lastResult + (stckSign * result);
      }
    }

    result = result + (number*sign);
    return result;




  }
}