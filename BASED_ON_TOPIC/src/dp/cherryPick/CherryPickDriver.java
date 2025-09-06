package dp.cherryPick;

import java.util.Arrays;

public class CherryPickDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int cherryPickup(int[][] grid) {
    int n = grid.length;
    // Memoization array to store results for each state (r1, c1, r2)
    Integer[][][] memo = new Integer[n][n][n];
    // Call the DP function and return the result
    return Math.max(0, dp(grid, memo, 0, 0, 0));
  }

  private int dp(int[][] grid, Integer[][][] memo, int r1, int c1, int c2) {
    int n = grid.length;
    int r2 = r1 + c1 - c2;  // Calculate r2 based on r1, c1, and c2

    // Base case: Out of bounds or thorn cell (-1)
    if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }

    // If we reached the bottom-right corner, return the cherries at (r1, c1)
    if (r1 == n - 1 && c1 == n - 1) {
      return grid[r1][c1];
    }

    // Memoization: Return the result if it's already computed
    if (memo[r1][c1][c2] != null) {
      return memo[r1][c1][c2];
    }

    // Calculate the cherries collected at (r1, c1) and (r2, c2)
    int cherries = (r1 == r2 && c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];

    // Explore all four possible directions (right/down for both players)
    int maxCherries = Math.max(
        Math.max(dp(grid, memo, r1, c1 + 1, c2), dp(grid, memo, r1 + 1, c1, c2)), // right for r1, down for r1
        Math.max(dp(grid, memo, r1, c1 + 1, c2 + 1), dp(grid, memo, r1 + 1, c1, c2 + 1)) // right for r1, down for r2
    );

    // Memoize the result
    memo[r1][c1][c2] = (maxCherries == Integer.MIN_VALUE) ? Integer.MIN_VALUE : cherries + maxCherries;

    return memo[r1][c1][c2];
  }
}
