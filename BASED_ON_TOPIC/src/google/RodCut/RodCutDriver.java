package google.RodCut;

import java.util.Arrays;

public class RodCutDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().minCost(7,new int[]{1,3,4,5}));
  }
}


class Solution {
  public int minCost(int n, int[] cuts) {

    int[] cutsMerge = new int[cuts.length+2];
    cutsMerge[0] =0;
    cutsMerge[cuts.length+1] = n;

    for(int i=0; i<cuts.length;i++){
      cutsMerge[i+1] = cuts[i];
    }
    Arrays.sort(cutsMerge);

    int[][] dp = new int[cutsMerge.length][cutsMerge.length];
    for(int[] d: dp){
      Arrays.fill(d,-1);
    }

    return calculate(0,cutsMerge.length-1,cutsMerge,dp);

  }

  private int calculate(int i, int j,int[] cuts,int[][] dp ){

    if(j-i <= 1){
      return 0;
    }

    if(dp[i][j] != -1){
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE;
    for(int k =i+1; k< j;k++){

      int cost = calculate(i,k,cuts,dp) + calculate(k,j,cuts,dp) + (cuts[j]-cuts[i]);
      min = Math.min(cost, min);
    }
    return dp[i][j] = min;


  }
}
