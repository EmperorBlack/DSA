package array.aggresiveCow;

import java.util.Arrays;

public class AggressiveCowDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().findLargestMinDistance(new int[]{0,3,4,7,10,9},4));
  }
}

class Solution{

  public int findLargestMinDistance(int []stalls, int cows){

    Arrays.sort(stalls);
    return findLargestMinDistanceBS(stalls,cows,1,stalls[stalls.length-1]-stalls[0]);

  }

  private int findLargestMinDistanceBS(int []stalls, int cows, int i, int j){

    if(i > j){
      return j;
    }
    int mid = i + (j-i)/2;
    if(canWePlaceCow(stalls,cows,mid)){
      return findLargestMinDistanceBS(stalls,cows,mid+1,j);
    }else{
      return findLargestMinDistanceBS(stalls,cows,i,mid-1);
    }

  }

  private boolean canWePlaceCow(int stalls[], int cows, int minDist){

    int cowCount = 1;
    int last = stalls[0];
    for (int i = 1; i < stalls.length; i++) {
      if(stalls[i]-last >= minDist){
        cowCount++;
        last = stalls[i];
      }
    }
    return cowCount >= cows;

  }

}
