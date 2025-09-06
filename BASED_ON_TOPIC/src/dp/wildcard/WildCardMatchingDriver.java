package dp.wildcard;

import java.util.Arrays;

public class WildCardMatchingDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().isMatch("cb","?a"));
  }
}

class Solution {
  public boolean isMatch(String s, String p) {

    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//    for (int i = 0; i < dp.length; i++) {
//      Arrays.fill(dp[i],-1);
//    }
//    return isMatchHelper(s,p,s.length()-1,p.length()-1,dp);

    dp[0][0] = true;
    for (int j = 1; j <= p.length(); j++) {
      if(p.charAt(j-1) =='*'){
        dp[0][j] = true;
      }else{
        break;
      }
    }

    for (int i = 1; i < s.length()+1; i++) {

      for (int j = 1; j < p.length()+1 ; j++) {

        boolean isMatching = false;
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
          isMatching = dp[i-1][j-1];
        }else if(p.charAt(j-1) == '*'){
          isMatching = dp[i][j-1] || dp[i-1][j];
        }
        dp[i][j] = isMatching;

      }
    }
    return dp[s.length()][p.length()];


  }

  private boolean isMatchHelper(String s, String p, int i, int j, int[][] dp){

    if(i ==-1 && j ==-1){
      return true;
    }
    if(j == -1){
      return false;
    }
    if(i==-1 ){
      for (int k = 0; k <= j; k++) {
        if(p.charAt(k)!= '*'){
          return false;
        }
      }
      return true;
    }

    if(dp[i][j] != -1){
      return dp[i][j] == 1;
    }

    boolean isMatching = false;
    if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
      isMatching = isMatchHelper(s,p,i-1,j-1,dp);
    }else if(p.charAt(j) == '*'){
      isMatching = isMatchHelper(s,p,i,j-1,dp) || isMatchHelper(s,p,i-1,j,dp);
    }
    dp[i][j] = isMatching ? 1 : 0;
    return isMatching;

  }
}
