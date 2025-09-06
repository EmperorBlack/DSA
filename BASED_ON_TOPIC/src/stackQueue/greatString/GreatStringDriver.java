package stackQueue.greatString;

import java.util.ListIterator;
import java.util.Stack;

public class GreatStringDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().makeGood("leEeetcode"));
  }
}


class Solution {
  public String makeGood(String s) {
    Stack<Character> stack = new Stack<Character>();

    for(int i = 0; i< s.length();i++){
      char c = s.charAt(i);
      if(stack.isEmpty() || Character.toLowerCase(stack.peek()) != Character.toLowerCase(c) ){
        stack.push(c);
      }else if(stack.peek()-c != 0){
        stack.pop();
      }else{
        stack.push(c);
      }
    }

    StringBuilder sb = new StringBuilder();
    ListIterator<Character> lt = stack.listIterator();
    while (lt.hasNext()) {
      sb.append(lt.next());
    }
    return sb.toString();


  }
}