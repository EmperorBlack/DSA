package google.maxfreeTime;

public class MaxFreeTimeDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().maxFreeTime(309,new int[]{15,28,65,106,223,280},new int[]{24,47,68,218,257,308}));
  }
}

class Solution {
  public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

    int n = endTime.length;
    int[] freeTime = new int[n+1];
    int last =0;
    for(int i =0; i<n; i++){
      freeTime[i] = startTime[i]-last;
      last = endTime[i];
    }
    freeTime[n] = eventTime - last;

    int[] nextBig = new int[n];
    int[] preBig = new int[n];

    int currMax = 0;
    int previousMax = 0;

    for (int i = 0; i < n; i++) {
      preBig[i] = previousMax;
      if(freeTime[i] > currMax){
        currMax = freeTime[i];
      }
      previousMax = currMax;
    }

    currMax = 0;
    previousMax = 0;
    for (int i = n-1; i >= 0 ; i--) {
      nextBig[i] = previousMax;
      if(freeTime[i+1] > currMax){
        currMax = freeTime[i+1];
      }
      previousMax = currMax;

    }

    int maxFreeTime = 0;
    for (int i = 0; i < n; i++) {

      int currEventTime = endTime[i] - startTime[i];

      if(preBig[i] >= currEventTime || nextBig[i] >= currEventTime ){
        maxFreeTime = Math.max(maxFreeTime, (currEventTime + freeTime[i]+freeTime[i+1]));
      }else{
        maxFreeTime = Math.max(maxFreeTime, freeTime[i] + freeTime[i+1]);
      }
    }

    return maxFreeTime;

  }
}
