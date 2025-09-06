package dp.distinctSubSequence;

import java.util.Arrays;

public class DistinctSubSequenceDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int numDistinct(String s, String t) {

    int[][] dp = new int[s.length()+1][t.length()+1];

    for (int i = 0; i <= s.length(); i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length() ; j++) {

        int take = 0;
        if(s.charAt(i-1) == t.charAt(j-1)){
          take = dp[i-1][j-1];
        }
        int notTake = dp[i-1][j];

        dp[i][j] = take+notTake;
      }
    }

    return dp[s.length()][t.length()];


//    for (int i = 0; i < dp.length; i++) {
//
//      Arrays.fill(dp[i],-1);
//    }
//
//    return numDistinctHelper(s,t,s.length()-1,t.length()-1,dp);
  }

  private int numDistinctHelper(String s, String t, int i, int j , int[][] dp){

    if(j == -1){
      return 1;
    }
    if(i ==-1){
      return 0;
    }

    if(dp[i][j] != -1){
      return dp[i][j];
    }

    int take = 0;
    if(s.charAt(i) == t.charAt(j)){
      take = numDistinctHelper(s,t,i-1,j-1,dp);
    }
    int notTake = numDistinctHelper(s,t,i-1,j,dp);

    return dp[i][j] = take+notTake;



  }
}
