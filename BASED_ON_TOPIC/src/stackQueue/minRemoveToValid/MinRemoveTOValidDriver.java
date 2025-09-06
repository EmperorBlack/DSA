package stackQueue.minRemoveToValid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class MinRemoveTOValidDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minRemoveToMakeValid("))(("));
  }
}


class Solution {
  public String minRemoveToMakeValid(String s) {


    Set<Integer> invalid = new HashSet<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {

      if(s.charAt(i) == '('){
        stack.push(i);
      } else if (s.charAt(i) == ')') {
        if(stack.isEmpty()){
          invalid.add(i);
        }else{
          stack.pop();
        }
      }
    }

    while (!stack.isEmpty()){
      invalid.add(stack.pop());
    }
    char[] arr = s.toCharArray();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if(!invalid.contains(i)){
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();

  }
}