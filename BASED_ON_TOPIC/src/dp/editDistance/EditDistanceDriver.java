package dp.editDistance;

import java.util.Arrays;

public class EditDistanceDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int minDistance(String word1, String word2) {

    int[][] dp = new int[word1.length()+1][word2.length()+1];

//    for (int i = 0; i < dp.length; i++) {
//      Arrays.fill(dp[i],-1);
//    }
//
//    return minDistanceHelper(word1,word2,word1.length()-1,word2.length()-1,dp);

    for (int i = 0; i < word1.length()+1; i++) {
      dp[i][0] = i;
    }

    for (int i = 0; i < word2.length()+1; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i < word1.length()+1; i++) {
      for (int j = 1; j < word2.length()+1; j++) {

        int result = 0;
        if(word1.charAt(i-1) == word2.charAt(j-1)){
          result = dp[i-1][j-1];
        }else{

          int insert = dp[i][j-1];
          int delete = dp[i-1][j];
          int replace = dp[i-1][j-1];
          result = Math.min(Math.min(insert,delete),replace)+1;
        }
        dp[i][j] = result;
      }
    }

    return dp[word1.length()][word2.length()];
  }

  private int minDistanceHelper(String word1, String word2, int i, int j, int[][] dp){

    if(j == -1){
      return i+1;
    }
    if(i == -1){
      return j+1;
    }
    if(dp[i][j] != -1){
      return dp[i][j];
    }

    int result = 0;
    if(word1.charAt(i) == word2.charAt(j)){
      result = minDistanceHelper(word1,word2,i-1,j-1,dp);
    }else{

      int insert = minDistanceHelper(word1,word2,i,j-1,dp);
      int delete = minDistanceHelper(word1,word2,i-1,j,dp);
      int replace = minDistanceHelper(word1,word2,i-1,j-1,dp);
      result = Math.min(Math.min(insert,delete),replace)+1;
    }
    return dp[i][j] = result;

  }
}
