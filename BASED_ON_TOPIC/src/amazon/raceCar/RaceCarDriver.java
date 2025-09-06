package amazon.raceCar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RaceCarDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().racecar(3));
  }
}






class Solution {

  public int racecar(int target) {
    Queue<State> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.offer(new State(0, 1));
    visited.add("0_1");

    int steps = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        State curr = queue.poll();

        if (curr.position == target) return steps;

        // Accelerate
        int newPos = curr.position + curr.speed;
        int newSpeed = curr.speed * 2;
        String accKey = newPos + "_" + newSpeed;
        if (Math.abs(newPos) <= 2 * target && visited.add(accKey)) {
          queue.offer(new State(newPos, newSpeed));
        }

        // Reverse
        newSpeed = curr.speed > 0 ? -1 : 1;
        String revKey = curr.position + "_" + newSpeed;
        if (visited.add(revKey)) {
          queue.offer(new State(curr.position, newSpeed));
        }
      }

      steps++;
    }

    return -1; // unreachable
  }

  static class State {
    int position;
    int speed;

    State(int p, int s) {
      this.position = p;
      this.speed = s;
    }
  }
}
