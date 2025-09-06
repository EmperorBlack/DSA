package dp.maxTaxiride;

import java.util.Arrays;

public class MaxTaxiRideDriver {

}

class Solution {
  public long maxTaxiEarnings(int n, int[][] rides) {
    // Sort rides by end time to ensure compatibility
    Arrays.sort(rides, (a, b) -> a[1] - b[1]);

    long[][] dp = new long[n + 1][rides.length];
    for (long[] row : dp) {
      Arrays.fill(row, -1);
    }

    return maxTaxiHelp(n, rides.length - 1, rides, dp);
  }

  private long maxTaxiHelp(int n, int curr, int[][] rides, long[][] dp) {
    if (curr < 0) return 0;

    if (dp[n][curr] != -1) return dp[n][curr];

    long take = 0;
    if (n >= rides[curr][1]) {
      take = maxTaxiHelp(rides[curr][0], curr - 1, rides, dp)
          + (rides[curr][1] - rides[curr][0]) + rides[curr][2];
    }

    long notTake = maxTaxiHelp(n, curr - 1, rides, dp);

    dp[n][curr] = Math.max(take, notTake);
    return dp[n][curr];
  }
}



class Solution_tab {
  public long maxTaxiEarnings(int n, int[][] rides) {
    // Sort rides by end time
    Arrays.sort(rides, (a, b) -> a[1] - b[1]);

    int m = rides.length;
    long[][] dp = new long[n + 1][m];

    // Initialize all values to 0
    for (long[] row : dp) {
      Arrays.fill(row, 0);
    }

    // Initialize the first column (ride 0)
    for (int i = 0; i <= n; i++) {
      if (i >= rides[0][1]) {
        dp[i][0] = rides[0][1] - rides[0][0] + rides[0][2];
      }
    }

    // Fill the dp table
    for (int i = 1; i <= n; i++) {
      for (int curr = 1; curr < m; curr++) {
        long take = 0;
        if (i >= rides[curr][1]) {
          take = dp[rides[curr][0]][curr - 1]
              + (rides[curr][1] - rides[curr][0]) + rides[curr][2];
        }

        long notTake = dp[i][curr - 1];
        dp[i][curr] = Math.max(take, notTake);
      }
    }

    return dp[n][m - 1];
  }
}

class Solution_3 {
  public long maxTaxiEarnings(int n, int[][] rides) {
    // Sort rides by end time
    Arrays.sort(rides, (a, b) -> a[1] - b[1]);

    // dp[i]: max earnings till position i
    long[] dp = new long[n + 1];
    int rideIdx = 0;

    for (int i = 1; i <= n; i++) {
      // Don't take any new ride at time i
      dp[i] = dp[i - 1];

      // Take all rides ending at i
      while (rideIdx < rides.length && rides[rideIdx][1] == i) {
        int start = rides[rideIdx][0];
        int end = rides[rideIdx][1];
        int tip = rides[rideIdx][2];

        dp[i] = Math.max(dp[i], dp[start] + (end - start + tip));
        rideIdx++;
      }
    }

    return dp[n];
  }
}

