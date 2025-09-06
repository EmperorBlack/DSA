package google.carPolling;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CarPollingDriver {

  public static void main(String[] args) {


    System.out.println(new Solution().carPooling(new int[][]{{3,2,8},{4,4,6},{10,8,9}}, 11));
  }
}
class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips,(t1, t2) -> Integer.compare(t1[1], t2[1]));

    Queue<int[]> queue = new PriorityQueue<>((t1,t2)-> Integer.compare(t1[2],t2[2]));
    int currentPassengers = 0;
    for(int i=0;i<trips.length;i++){
      queue.offer(trips[i]);
      currentPassengers += trips[i][0];

      while(!queue.isEmpty() && queue.peek()[2] <= trips[i][1]){
        currentPassengers=currentPassengers - queue.poll()[0];
      }

      if(currentPassengers > capacity){
        return false;
      }
    }
    return true;

  }
}