package recursion.sortStack;

import java.util.Stack;

public class SortStackDriver {

  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();
    stack.push(11);
    stack.push(2);
    stack.push(32);
//    stack.push(3);
//    stack.push(4);
//    new GfG().sort(stack);
    Solution.reverse(stack);
    System.out.println(stack);
  }
}


class GfG {
  public Stack<Integer> sort(Stack<Integer> s) {
    // add code here.
    retrivElement(s);
    return s;
  }


  public void retrivElement(Stack<Integer> s){

    if(s.isEmpty()){
      return;
    }

    int element = s.pop();

    retrivElement(s);

    sortElement(s,element);
  }

  public void sortElement(Stack<Integer> s, Integer element){

    if(s.isEmpty() || s.peek() <= element ){
      s.push(element);
      return;
    }

    int ele = s.pop();
    sortElement(s,element);
    s.push(ele);
  }
}


class Solution
{
  static void reverse(Stack<Integer> s)
  {
    // add your code here

    if(s.isEmpty()){
      return;
    }

    int element = s.pop();
    reverse(s);
    reverseInsert(s,element);

  }

  static void reverseInsert(Stack<Integer> s, Integer ele)
  {
    // add your code here

    if(s.isEmpty()){
      s.push(ele);
      return;
    }

    int element = s.pop();
    reverseInsert(s,ele);
    s.push(element);
  }


}