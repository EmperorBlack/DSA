package dp.minPathFalling;

public class MinPathFailingDriver {

  public static void main(String[] args) {

    int[][] matrix = {
        {2, 1, 3},
        {6, 5, 4},
        {7, 8, 9}
    };
    System.out.println(new Solution().minFallingPathSum(matrix));
  }
}

class Solution {
  public int minFallingPathSum(int[][] matrix) {


//    int m = matrix.length;
//    int n = matrix[0].length;
//    int[][] dp = new int[m][n];
//
//    for (int i = 0; i < m; i++) {
//      for (int j = 0; j < n; j++) {
//        dp[i][j] = -1;
//      }
//    }
//
//    int min = Integer.MAX_VALUE;
//    for (int i = 0; i < matrix[0].length; i++) {
//
//      int result = minFallingPathSumHelper(matrix, m-1, i,dp);
//      if(result < min){
//        min = result;
//      }
//    }
//    return min;
    return  minFallingPathSumTab(matrix);

  }

  private int minFallingPathSumHelper(int[][] matrix, int i, int j, int[][] dp){



    if(j < 0 || j >= matrix[0].length){
      return Integer.MAX_VALUE;
    }

    if(i == 0){
        return matrix[0][j];
    }

    if(dp[i][j] != -1){
      return matrix[i][j];
    }

    int left = minFallingPathSumHelper(matrix, i-1, j-1,dp);
    int down = minFallingPathSumHelper(matrix, i-1, j,dp);
    int right = minFallingPathSumHelper(matrix, i-1, j+1,dp);

    return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));

  }

  private int minFallingPathSumTab(int[][] matrix){

    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {

        int left = j > 0 ? matrix[i-1][j-1] : Integer.MAX_VALUE;
        int down = matrix[i-1][j];
        int right = j < n-1 ? matrix[i-1][j+1] : Integer.MAX_VALUE;

        matrix[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));

      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {

      if(matrix[m-1][i] < min){
        min = matrix[m-1][i];
      }
    }
    return min;

  }
}
