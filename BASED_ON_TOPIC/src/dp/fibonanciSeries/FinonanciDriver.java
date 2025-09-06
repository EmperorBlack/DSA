package dp.fibonanciSeries;

import java.util.ArrayList;
import java.util.Arrays;

public class FinonanciDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int fib(int n) {

    int[] dp = new int[n+1];
    Arrays.fill(dp,-1);;
    return fibMemo(n,dp);

  }

  private int fibMemo(int n, int[] dp){
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }
    if(dp[n] != -1){
      return dp[n];
    }
    return dp[n] = fib(n-1) + fib(n-2);
  }

  private int fibTab(int n){

    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n ; i++) {

      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];

  }
}
