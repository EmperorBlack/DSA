package dp.longestCommonSubString;

import java.util.Arrays;

public class LongestCommonSubstringDriver {

  public static void main(String[] args) {

    System.out.println(Solution.lcs("yxxzzzxxxx","yzyzxxyxxz"));
  }
}

class Solution {

  static int max = Integer.MIN_VALUE;
  public static int lcs(String s, String t) {

    max = Integer.MIN_VALUE;

    int[][] dp = new int[s.length()][t.length()];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i],-1);
    }
    lcsHelper(s,t,s.length()-1,t.length()-1,dp);
    return lcsTab(s,t);

  }

  private static int lcsHelper(String s, String t, int i, int j , int[][] dp){

    if(i < 0 || j <0){
      return 0;
    }

    if(dp[i][j] != -1){
      return dp[i][j];
    }

    int maxTill =0;
    if(s.charAt(i) == t.charAt(j)){
      maxTill = lcsHelper(s,t,i-1,j-1,dp)+1;
      max = Math.max(max,maxTill);
    }
      lcsHelper(s,t,i-1,j,dp);
      lcsHelper(s,t,i,j-1,dp);


    return dp[i][j] = maxTill;


  }

  private static int lcsTab(String s, String t){
    int m = s.length()+1;
    int n = t.length()+1;

    int[][] dp = new int[m][n];
    int max = 0;

    for (int i = 1; i < m; i++) {

      for (int j = 1; j < n; j++) {

        if(s.charAt(i-1) == t.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1]+1;
          max = Math.max(dp[i][j],max);
        }

      }

    }

    return max;


  }
}