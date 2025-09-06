package slidingWindowAndTwoPointer.maxPointFromCards;

import java.util.Map;

public class MaxPointFromCardDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().maxScore(new int[]{1,2,3,4,5,6,1},3));
  }
}

//we will run a window of size n-k
//and will finf min subarray,
//then will return total sum - minsubarray

class Solution {
  public int maxScore(int[] cardPoints, int k) {

    int win = (cardPoints.length-k)-1; //for 0 indexing
    int sum = 0;
    int minSum = Integer.MAX_VALUE;
    int totalSum = 0;
    for (int cardPoint : cardPoints) {
      totalSum += cardPoint;
    }
    if(win < 0){
      return totalSum;
    }
    for (int i = 0; i < cardPoints.length; i++) {

      sum= sum+cardPoints[i];

      if(i>= (win)){

        minSum = Math.min(minSum,sum);
        sum = sum - cardPoints[i-win];
      }
    }
    return totalSum-minSum;
  }
}


class Solution_2 {
  public int maxScore(int[] cardPoints, int k) {

    int sum = 0;
    int maxSum = Integer.MIN_VALUE;

    int l = k-1;
    int r = cardPoints.length-1;
    while(l>=0){
      sum = sum+cardPoints[l--];
    }
    maxSum = sum;
    l =k-1;

    while (r >= (cardPoints.length-k) ){
      sum = sum+cardPoints[r]-cardPoints[l];
      l--;
      r--;
      maxSum = Math.max(maxSum,sum);
    }
    return maxSum;
  }
}