package greedy.insertInterval;

import java.util.Arrays;

public class InsertIntervalDriver {

  public static void main(String[] args) {

    System.out.println(
        Arrays.deepToString(new Solution().insert(new int[][]{{1,5}}, new int[]{2, 3})));
  }
}

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {

    int index = binarySearch(intervals,newInterval[0]);

    int[][] result = new int[intervals.length+1][];

    for (int i = 0; i < index; i++) {
      result[i] = intervals[i];
    }
    result[index] = newInterval;
    for (int i = index; i < intervals.length; i++) {
      result[i+1] = intervals[i];
    }

    int count = 0;
    for (int i = 1; i < result.length; i++) {
      if(result[i-1][1] >= result[i][0]){
        result[i][0] = result[i-1][0];
        result[i][1] = Math.max(result[i][1],result[i-1][1]);
        result[i-1] = null;
        count++;
      }
    }

    int[][] mergeArray = new int[result.length-count][];
    int k =0;
    for (int i = 0; i < result.length; i++) {
      if(result[i] != null){
        mergeArray[k] = result[i];
        k++;
      }
    }
    return mergeArray;



  }

  private int binarySearch(int[][] intervals, int target){


    if(intervals.length ==0){
      return 0;
    }
    int l =0;
    int r = intervals.length-1;

    while (l<=r){
      int mid = l+(r-l)/2;

      if(intervals[mid][0] > target){
        r = mid-1;
      }else {
        l = mid+1;
      }
    }

    return l;



  }
}
