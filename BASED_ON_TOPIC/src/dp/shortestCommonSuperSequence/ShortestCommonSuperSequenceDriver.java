package dp.shortestCommonSuperSequence;

import java.util.Arrays;

public class ShortestCommonSuperSequenceDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().shortestCommonSupersequence("aaaaaaa","aaaaaaaa"));
  }
}


class Solution {
  public String shortestCommonSupersequence(String str1, String str2) {

    int[][] dp = new int[str1.length()+1][str2.length()+1];
//    for (int i = 0; i < dp.length; i++) {
//
//      Arrays.fill(dp[i],-1);
//    }
//
//    int result = shortestCommonSSHelper(str1,str2,str1.length()-1,str2.length()-1,dp);
//
//    System.out.println(result);

    for (int i = 0; i <= str1.length(); i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= str2.length(); i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 1; j <= str2.length(); j++) {

        int result = 0;
        if(str1.charAt(i-1) == str2.charAt(j-1)){
          result = 1+dp[i-1][j-1];
        }else{
          result = 1+Math.min(dp[i-1][j],dp[i][j-1]);
        }
        dp[i][j] = result;
      }
    }


    int i = str1.length();
    int j = str2.length();

    StringBuilder sb = new StringBuilder();
    while (i>0 && j>0){


      if(str1.charAt(i-1) == str2.charAt(j-1)){
        sb.insert(0,str1.charAt(i-1));
        i--;
        j--;
      }else {
        if(dp[i-1][j] < dp[i][j-1]){
          sb.insert(0,str1.charAt(i-1));
          i--;
        }else {
          sb.insert(0,str2.charAt(j-1));
          j--;
        }
      }

    }

    while (i>0){
      sb.insert(0,str1.charAt(i-1));
      i--;
    }
    while (j>0){
      sb.insert(0,str2.charAt(j-1));
      j--;
    }

    return sb.toString();

  }

  private int shortestCommonSSHelper(String str1, String str2, int i , int j, int[][] dp){


    if(i == -1 || j ==-1){
      return i+j+2;
    }

    if(dp[i][j] != -1){
      return dp[i][j];
    }

    int result = 0;
    if(str1.charAt(i) == str2.charAt(j)){
      result = 1+ shortestCommonSSHelper(str1,str2,i-1,j-1,dp);
    }else{
      result = 1+ Math.min(shortestCommonSSHelper(str1,str2,i,j-1,dp), shortestCommonSSHelper(str1,str2,i-1,j,dp));
    }

    return dp[i][j] = result;

  }


}