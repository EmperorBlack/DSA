package array.MinTimeToCompleteTree;

import java.util.Arrays;

public class MinTimeToCompleteTreeDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minimumTime(new int[]{2},1));
  }
}

class Solution {
  public long minimumTime(int[] time, int totalTrips) {
    int min = Arrays.stream(time).min().getAsInt();

    long maxTime = (long) min * totalTrips;

    long l =0;

    while (l <= maxTime){

      long mid = l+ (maxTime-l)/2;
      long count = tripCount(time,mid);

      if(count >= totalTrips){
        maxTime = mid-1;
      }else{
        l = mid+1;
      }


    }

    return l;
  }

  private long tripCount(int[] time, long tripTime){

    long count = 0L;
    for (int i = 0; i < time.length; i++) {

      count += tripTime/time[i];
    }
    return count;

  }
}