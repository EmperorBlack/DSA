package dp.decodeWays;

import java.util.Arrays;

public class DecodeWaysDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().numDecodings("2101"));


  }


}



class Solution {
  public int numDecodings(String s) {


    int[] dp = new int[s.length()];
    Arrays.fill(dp,-1);
    return numDecodehelp(s,0,dp);


  }

  private int numDecodehelp(String s,int index, int[] dp) {

    if(index == s.length()){
      return 1;
    }

    if(s.charAt(index) =='0'){
      return 0;
    }

    if(dp[index] != -1){
      return dp[index];
    }


    int ways = numDecodehelp(s,index+1,dp);
    if(index < s.length()-1 && Integer.parseInt(s.substring(index,index+2))<27){
      ways+= numDecodehelp(s,index+2,dp);
    }


    return dp[index] = ways;
  }

}