package google.maximumCandies;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MaximumCandiesDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

    Queue<Integer> queue = new ArrayDeque<>();

    boolean visited[] = new boolean[candies.length];
    Set<Integer> pending = new HashSet<>();
    for (int i = 0; i < initialBoxes.length; i++) {

      int curr = initialBoxes[i];
      if(status[curr] == 1){
        queue.offer(initialBoxes[i]);
        visited[curr] = true;
      }else{
        pending.add(curr);
      }
    }

    int count =0;

    while (!queue.isEmpty() ){

      int currBox = queue.poll();
      count += candies[currBox];

      for (int i = 0; i < containedBoxes[currBox].length; i++) {
        int next = containedBoxes[currBox][i];
        if(!visited[next] && status[next] == 1 ){
          queue.offer(next);
          visited[next] = true;
        }

        if(status[next] == 0){
          pending.add(next);
        }
      }

      for (int i = 0; i < keys[currBox].length; i++) {
        int key = keys[currBox][i];
        if(status[key] == 0){
          status[key] = 1;
          if(pending.contains(key)){
            queue.offer(key);
            pending.remove(key);
            visited[key] = true;
          }
        }
      }

    }

return count;
  }
}