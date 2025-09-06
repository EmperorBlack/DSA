package dp.interlevingString;

import java.util.Arrays;

public class interLevingDriver {

  public static void main(String[] args) {

  }

}

class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {

    if(s1.length()+s2.length() != s3.length()){
      return false;
    }

    int[][] dp = new int[s1.length()][s2.length()];
    for (int[] d : dp){
      Arrays.fill(d,-1);
    }

    return isPossible(s1,s2,s3,s1.length()-1,s2.length()-1,s3.length()-1,dp);


  }

  private boolean isPossible(String s1, String s2, String s3, int i, int j , int k,int[][] dp){

    if(i < 0 && j < 0){
        return true;
    }

    if(i >= 0 && j >= 0 && dp[i][j] != -1){
      return dp[i][j] == 1;
    }

    boolean chooseFromS1 = false;
    if(i >= 0 && s1.charAt(i) == s3.charAt(k)){
      chooseFromS1 = isPossible(s1,s2,s3,i-1,j,k-1,dp);
    }

    boolean chooseFrom2 = false;
    if(j >=0 && s2.charAt(j) == s3.charAt(k)){
      chooseFrom2 = isPossible(s1,s2,s3,i,j-1,k-1,dp);
    }

    if(i >=0 && j >=0){
      dp[i][j] = (chooseFromS1 || chooseFrom2) ? 1 : 0;
    }
    return  (chooseFromS1 || chooseFrom2);


  }
}
