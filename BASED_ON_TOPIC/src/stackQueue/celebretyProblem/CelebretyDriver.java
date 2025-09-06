package stackQueue.celebretyProblem;

import java.util.Stack;

public class CelebretyDriver {

}

interface Runner{

  static boolean knows(int a, int b) {
    return true;
  }
}

class Solution {
  public static int findCelebrity(int n) {

    Stack<Integer> stack = new Stack<>();
    int celebrety = n-1;
    for (int i = 0; i < n-1; i++) {
      stack.push(i);
    }

    while (!stack.isEmpty()){
      int next = stack.pop();
      if(Runner.knows(celebrety,next)){
        celebrety = next;
      }
    }

    for (int i = 0; i < n; i++) {
      if(celebrety!=i && (Runner.knows(celebrety,i) || !Runner.knows(i,celebrety))){
        return -1;
      }
    }
    return celebrety;
  }
}