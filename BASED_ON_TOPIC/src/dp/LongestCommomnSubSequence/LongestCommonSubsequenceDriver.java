package dp.LongestCommomnSubSequence;

import java.util.Arrays;

public class LongestCommonSubsequenceDriver {

}

class Solution {
  public int longestCommonSubsequence(String text1, String text2) {

//    int[][] dp = new int[text1.length()][text2.length()];
//    for (int i = 0; i < dp.length; i++) {
//      Arrays.fill(dp[i],-1);
//    }
//    return lcsHelper(text1,text2,text1.length()-1,text2.length()-1,dp);
//    return lcsTab(text1,text2);

    return lcsTabIndexShift(text1,text2);
  }

  private int lcsHelper(String text1, String text2, int i, int j, int[][] dp){


    if(i ==-1 || j ==-1){
      return 0;
    }

    if(dp[i][j] != -1){
      return dp[i][j];
    }

    int result = 0;
    if(text1.charAt(i) == text2.charAt(j)){
      result = lcsHelper(text1,text2,i-1,j-1,dp)+1;
    }else{
      result = Math.max(lcsHelper(text1,text2,i,j-1,dp), lcsHelper(text1,text2,i-1,j,dp));
    }

    return dp[i][j] = result;



  }

  private int lcsTab(String text1, String text2){

    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      if(text1.charAt(i) == text2.charAt(0)){
        dp[i][0] = 1;
      }
    }

    for (int i = 0; i < n; i++) {
      if(text1.charAt(0) == text2.charAt(i)){
        dp[0][i] = 1;
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int result = 0;
        if(text1.charAt(i) == text2.charAt(j)){
          if(i-1 >= 0 && j-1 >=0){
            result = dp[i-1][j-1]+1;
          }else{
            result = 1;
          }
        }else{

          int left = i-1 >=0 ? dp[i-1][j] : 0;
          int right = j-1 >=0? dp[i][j-1] : 0;
            result = Math.max(left,right);

        }
        dp[i][j] = result;

      }
    }

return dp[m-1][n-1];

  }

  private int lcsTabIndexShift(String text1, String text2){

    int m = text1.length()+1;
    int n = text2.length()+1;
    int[][] dp = new int[m][n];



    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        int result = 0;
        if(text1.charAt(i-1) == text2.charAt(j-1)){
          result = dp[i-1][j-1]+1;
        }else{
          result = Math.max(dp[i][j-1], dp[i-1][j]);
        }
        dp[i][j] = result;

      }
    }

    return dp[m-1][n-1];

  }
}
