package math.allDivisor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllDivisorDriver {

  public static void main(String[] args) {
    Solution.print_divisors(20);
  }
}

class Solution {
  public static void print_divisors(int n) {
    Stack<Integer> stack = new Stack<>();
// i *i <= N
    for (int i = 1; i <= Math.sqrt(n); i++) {

      if(n%i == 0){
        System.out.print(i + " ");
        if(i != (n/i)){
          stack.push(n/i);
        }
      }

    }
   while (!stack.isEmpty())
     System.out.print(stack.pop()+" ");
   }


}