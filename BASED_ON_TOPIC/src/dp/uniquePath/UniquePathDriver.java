package dp.uniquePath;

public class UniquePathDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().uniquePaths(3, 7));
  }
}

class Solution {
  public int uniquePaths(int m, int n) {

    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1;
      }
    }
//    return uniquePathHelper(m-1,n-1,dp);

    return uniquePathTab(m,n,dp);
  }

  private int uniquePathHelper(int m, int n, int[][] dp){

    if(m ==0 && n == 0){
      return 1;
    }

    if(m < 0 || n <0){
      return 0;
    }

    if(dp[m][n] != -1){
      return dp[m][n];
    }

    return dp[m][n] = uniquePathHelper(m-1,n,dp)+ uniquePathHelper(m,n-1,dp);
  }

  private int uniquePathTab(int m, int n, int[][] dp){

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {

        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }

    return dp[m-1][n-1];

  }
}
