package slidingWindowAndTwoPointer.robotWithinBudget;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class RobotWithinBudgetDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {


    Deque<Integer> deque = new ArrayDeque<>();
    long currBudget = 0;
    int maxCount = 0;
    long currRunningCost =0;
    int l =0;


    for (int i = 0; i < runningCosts.length ; i++) {



      while (!deque.isEmpty() && chargeTimes[i] >= chargeTimes[deque.peekLast()]){
        deque.pollLast();
      }
      deque.offer(i);
      int currMax = chargeTimes[deque.peek()];


      currRunningCost = currRunningCost+runningCosts[i];
      currBudget = currMax + ((i - l + 1) * currRunningCost);

      if(currBudget <= budget){
        maxCount = Math.max(i-l+1,maxCount);
      }else {

        if(!deque.isEmpty() && deque.peek() <= l){
          deque.poll();
        }
        currRunningCost = currRunningCost-runningCosts[l];
        l++;
      }

    }


    return maxCount;

  }
}