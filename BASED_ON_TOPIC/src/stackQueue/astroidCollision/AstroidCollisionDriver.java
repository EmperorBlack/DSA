package stackQueue.astroidCollision;

import java.util.Arrays;
import java.util.Stack;

public class AstroidCollisionDriver {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{-2,-1,1,2})));
  }
}

class Solution {
  public int[] asteroidCollision(int[] asteroids) {

    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {

      if(asteroid > 0){
        stack.push(asteroid);
      }else {


          while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()){
            stack.pop();
          }

          if(!stack.isEmpty() &&  stack.peek() > 0 && Math.abs(asteroid) == stack.peek()){
            stack.pop();
          } else if (stack.empty() || stack.peek() < 0 ) {
            stack.push(asteroid);
          }


      }

    }

    int[] result = new int[stack.size()];

    for (int i = result.length-1; i >=0 ; i--) {
      result[i] = stack.pop();

    }
    return result;

  }
}
