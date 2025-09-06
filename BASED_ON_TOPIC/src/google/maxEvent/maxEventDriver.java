package google.maxEvent;

import java.util.Arrays;

public class maxEventDriver {

  public static void main(String[] args) {

//    [[1,2],[1,2],[3,3],[1,5],[1,5]]
    System.out.println( new Solution().maxEvents(new int[][]{{1,2},{1,2},{3,3},{1,5},{1,5}}));
  }
}

class Solution {
  public int maxEvents(int[][] events) {

    Arrays.sort(events, (a, b) -> a[0] - b[0]);
    int maxDay = 0;
    for (int[] event : events) {
      maxDay = Math.max(maxDay, event[1]);
    }
    boolean[] days = new boolean[maxDay + 1];
    int count = 0;
    for (int i = events.length-1; i >=0 ; i--) {

      int[] event = events[i];
      int start = event[0];
      int end = event[1];

      for(int j = end; j>= start;j-- ){
        if(!days[j]){
          days[j] = true;
          count++;  // increment the count of attended events
          // mark the day as attended
          break; // move to the next event
        }
      }
    }
    return count;

  }
}
