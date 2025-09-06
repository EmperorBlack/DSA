package google.maxEnvelope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxEnvelopeDriver {

  public static void main(String[] args) {

    System.out.println(new Solution_BU().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
  }
}


class Solution {
  public int maxEnvelopes(int[][] envelopes) {

    Arrays.sort(envelopes,(env1,env2)-> Integer.compare(env1[0], env2[0]));
    int[][] dp = new int[envelopes.length][envelopes.length+1];
    for (int[] d: dp){
      Arrays.fill(d,-1);
    }
    return maxEnvelope(envelopes, envelopes.length-1, envelopes.length,dp);


  }

  private int maxEnvelope(int[][] envelopes, int index, int lastIndex, int[][] dp){


    if(index < 0){
      return 0;
    }


    if(dp[index][lastIndex] != -1){
      return dp[index][lastIndex];
    }


    int choose = Integer.MIN_VALUE;

    int[] curr;
    if(lastIndex>= envelopes.length){
      curr = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
    }else{
      curr = envelopes[lastIndex];
    }

    if(envelopes[index][0] < curr[0] && envelopes[index][1] < curr[1]){
      choose = maxEnvelope(envelopes,index-1,index,dp)+1;
    }
    int notChoose = maxEnvelope(envelopes,index-1,lastIndex,dp);
    return dp[index][lastIndex] = Math.max(choose,notChoose);

  }
}


class Solution_BU {
  public int maxEnvelopes(int[][] envelopes) {

    Arrays.sort(envelopes,(env1,env2)-> Integer.compare(env1[0], env2[0]));
    int[] dp = new int[envelopes.length];
    Arrays.fill(dp,1);

    int result = 1;
    for (int i = 1; i < envelopes.length; i++) {

      for (int j = 0; j < i; j++) {

        if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          if(dp[i] < dp[j]+1){
            dp[i] = dp[j]+1;
          }
        }
      }

      result = Math.max(dp[i],result);
    }


return result;
  }


}

class Solution_BS {
  public int maxEnvelopes(int[][] envelopes) {

    Arrays.sort(envelopes, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0] == o2[0]){
          return Integer.compare(o2[1],o1[1]);
        }
        return Integer.compare(o1[0],o2[0]);
      }
    });

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < envelopes.length; i++) {
      list.add(envelopes[i][1]);
    }

    List<Integer> result = new ArrayList<>();
    for (Integer integer : list) {
      int pos = Collections.binarySearch(result, integer);
      if (pos < 0) {
        pos = -pos - 1;
      }

      if (pos == result.size()) {
        result.add(integer);
      } else {
        result.set(pos, integer);
      }
    }

    return result.size();






  }


}