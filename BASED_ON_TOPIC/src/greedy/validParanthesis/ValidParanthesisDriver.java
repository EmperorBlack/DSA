package greedy.validParanthesis;

import java.util.Stack;

public class ValidParanthesisDriver {

  public static void main(String[] args) {

  }
}

//stack Solution
class Solution {
  public boolean checkValidString(String s) {

    Stack<Integer> open = new Stack<>();
    Stack<Integer> star = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '('){
        open.push(i);
      } else if (s.charAt(i) == '*') {
        star.push(i);
      }else{
        if(!open.isEmpty()){
          open.pop();
        } else if (!star.isEmpty()) {
          star.pop();
        }else{
          return false;
        }
      }
    }

    while (!open.isEmpty()){

      if(!star.empty() && star.peek() > open.peek()){
        open.pop();
        star.pop();
      }else{
        return false;
      }

    }
    return true;

  }
}

//Range solution by striver
class Solution_2 {
  public boolean checkValidString(String s) {

    int min =0;
    int max =0;
    for (int i = 0; i < s.length(); i++) {

      if(s.charAt(i) == '('){
        min =min+1;
        max = max+1;
      } else if (s.charAt(i) == ')') {
        min = min-1;
        max = max-1;
      }else{
        min = min-1;
        max = max+1;
      }
      if(min < 0){
        min =0;
      }
      if(max < 0){
        return false;
      }
    }

    return min == 0;


  }
}