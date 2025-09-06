package dp.LIS.printLongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class PrintLongestIncreasingSubDriver {

  public static void main(String[] args) {
    System.out.println(Solution.printingLongestIncreasingSubsequence(new int[]{5, 6, 3, 4, 7, 6},6));
  }
}


class Solution {
  public static List<Integer> printingLongestIncreasingSubsequence(int []arr, int x) {

    int[] dp = new int[arr.length];
    int[] indexTrack = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      dp[i] = 1;
      indexTrack[i] = -1;
    }
    int max = 1;
    int maxIndex = 0;

    for (int i = 0; i < arr.length; i++) {

      for (int j = 0; j < i; j++) {

        if(arr[i] > arr[j] && dp[j]+1 > dp[i]){

          dp[i] = dp[j]+1;
          indexTrack[i] = j;
          if(dp[i] > max){
            max = dp[i];
            maxIndex = i;
          }
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    while (maxIndex >=0){
      result.add(0,arr[maxIndex]);
      maxIndex = indexTrack[maxIndex];
    }

    return result;

  }
}