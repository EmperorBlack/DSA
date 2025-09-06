package dp.printLongestCommonSub;

public class PrintLcsDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public static String findLCS(int n, int m, String s1, String s2){
    // Write your code here.

    n = n+1;
    m = m+1;

    int[][] dp = new int[n][m];

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {

        int result = 0;
        if(s1.charAt(i-1) == s2.charAt(j-1)){
          result = dp[i-1][j-1]+1;
        }else{
          result = Math.max(dp[i-1][j], dp[i][j-1]);
        }
        dp[i][j] = result;
      }
    }

    StringBuilder sb = new StringBuilder();
    int i = n-1;
    int j =m-1;

    while (i>=0 && j>=0){

      if(s1.charAt(i-1) == s2.charAt(j-1)){
        sb.insert(0,s1.charAt(i));
        i--;
        j--;
      }else{
        if(dp[i][j-1] > dp[i-1][j]){
          j--;
        }else {
          i--;
        }
      }
    }



    return sb.toString();

  }



}
