package greedy.nonOverLapping;

import java.util.Arrays;

public class NonOverLappingDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {


    int count = 0;

    Arrays.sort(intervals,(int[] a, int[] b)-> Integer.compare(a[0],b[0]));
    int last = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {

      if(intervals[i][0] < last){
        count++;
        last = Math.min(last,intervals[i][1]);
      }else{
        last = intervals[i][1];
      }

    }
    return count;

  }
}
