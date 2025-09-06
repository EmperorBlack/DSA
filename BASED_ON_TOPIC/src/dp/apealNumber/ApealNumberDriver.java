package dp.apealNumber;

import java.util.HashMap;
import java.util.Map;

public class ApealNumberDriver {


  public static void main(String[] args) {

    System.out.println(new Solution().appealSum("abcdb"));
  }
}


class Solution {
  public long appealSum(String s) {

    Map<Character,Integer> map = new HashMap<>();

    long[] dp = new long[s.length()];
    dp[0] = 1;
    long sum =1;
    map.put(s.charAt(0),0);

    for (int i = 1; i < s.length(); i++) {

      char c = s.charAt(i);

      if(map.containsKey(c)){
        dp[i] = dp[i-1] + i-map.get(c);
      }else {
        dp[i] = dp[i-1] + i+1;
      }
      map.put(c,i);
      sum += dp[i];

    }

    return sum;
  }
}
