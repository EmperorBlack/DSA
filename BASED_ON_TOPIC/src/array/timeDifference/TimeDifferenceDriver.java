package array.timeDifference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimeDifferenceDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().findMinDifference(Arrays.asList("01:01","02:01","03:00")));
  }
}



class Solution {
  public int findMinDifference(List<String> timePoints) {

    Collections.sort(timePoints);
    int min = Integer.MAX_VALUE;
    min = Math.min(min,getCircularDifference(timePoints.get(0),timePoints.get(timePoints.size()-1)));
    for(int i = 1;i<timePoints.size();i++){
      int minDiff = getMinuteDifference(timePoints.get(i),timePoints.get(i-1));
      min = Math.min(min,minDiff);
    }
    return min;

  }

  private int getCircularDifference(String fast, String last){

    int lastDifference = getMinuteDifference("24:00",last);
    int firstDifference = getMinuteDifference(fast,"00:00");
    return lastDifference+firstDifference;

  }

  private int getMinuteDifference(String latest, String previous){

    String[] latestSegment = latest.split(":");
    String[] previousSegment = previous.split(":");

    int latestMinutes = Integer.parseInt(latestSegment[1]) + (Integer.parseInt(latestSegment[0]) * 60);
    int previousMinute = Integer.parseInt(previousSegment[1]) + (Integer.parseInt(previousSegment[0]) * 60);

    return latestMinutes-previousMinute;

  }
}
