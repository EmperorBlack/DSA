package google.differentWaysToAddParanthesis;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToAddParanthesisDriver {

  public static void main(String[] args) {

  }
}



class Solution {
  public List<Integer> diffWaysToCompute(String expression) {

    if(expression == null || expression.isEmpty()){
      return List.of();
    }

    return calculate(expression,0,expression.length()-1);
  }


  private List<Integer> calculate(String exp, int l , int r ){

    if(l == r){
      return List.of(Character.getNumericValue(exp.charAt(l))); // base case, single number
    }

    List<Integer> result = new ArrayList<>();

    for (int i = l; i < r; i++) {
      char c  = exp.charAt(i);
      if(c ==  '+' || c== '-' || c == '*' ){
        List<Integer> left = calculate(exp,l,i-1);
        List<Integer> right = calculate(exp,i+1,r);

        for(Integer leftValue : left){
          for (Integer rightValue : right){

            if(c == '+'){
              result.add(leftValue +rightValue);
            } else if (c == '-') {
              result.add(leftValue-rightValue);
            }else {
              result.add(leftValue * rightValue);
            }
          }
        }
      }
    }
    if(result.isEmpty()){
      result.add(Integer.parseInt(exp.substring(l,r+1))); // if no operator found, return the number itself
    }
    return result;
  }
}