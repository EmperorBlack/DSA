package dp.cheryPickUpTwo;

import java.util.Arrays;

public class CheryPickUpDriver {

}

class Solution {
  public int cherryPickup(int[][] grid) {

    int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        Arrays.fill(dp[i][j],-1);
      }
    }



    int result = cherryPickUpHelper(grid,0,0,grid[0].length-1,dp);
return Math.max(result, 0);

  }

  private int cherryPickUpHelper(int[][] grid, int i, int j, int k, int[][][] dp){



    if(j < 0 ||  j>= grid[0].length || k <0 || k>= grid[0].length){
      return Integer.MIN_VALUE;
    }

    if(i == grid.length-1){
      if(j == k){
        return grid[i][j];
      }else{
        return grid[i][j] + grid[i][k];
      }
    }

    if(dp[i][j][k]!=-1){
      return dp[i][j][k];
    }

    int max = Integer.MIN_VALUE;
    for (int l = -1; l<=1; l++) {
      for (int m = -1; m <=1 ; m++) {

        int temp =0;
        if(j ==k){
          temp = grid[i][j] + cherryPickUpHelper (grid, i+1, j+l, k+m, dp);
        }else{
          temp = grid[i][j] + grid[i][k] + cherryPickUpHelper (grid, i+1, j+l, k+m, dp);
        }
        if(temp > max){
          max = temp;
        }
      }
    }
    return dp[i][j][k] = max;

  }
}