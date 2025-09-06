package dp.LIS.longestStringChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringCHainDriver {

  public static void main(String[] args) {

    System.out.println(new Solution_2().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
  }
}


class Solution {
  public int longestStrChain(String[] words) {

    Arrays.sort(words,(a,b)-> a.length()-b.length());
    return longestStringChainHelper(new HashMap<>(),words, words.length-1,"" );




  }
  private int longestStringChainHelper(Map<String,Map<String,Integer>> dp,String[] words, int index, String prv){

    if(index < 0){
      return 0;
    }

    String curr = words[index];
    if(dp.get(curr) != null && dp.get(curr).get(prv) != null){
      return dp.get(curr).get(prv);
    }

    int take = 0;
    if(prv.isEmpty()){
      take = longestStringChainHelper(dp,words,index-1,curr)+1;
    }
    StringBuilder sbCurr = new StringBuilder(prv);
    for(int i =0;i<sbCurr.length();i++){
      char c = sbCurr.charAt(i);
      sbCurr.delete(i,i+1);
      if(curr.contentEquals(sbCurr)){
        take = longestStringChainHelper(dp,words,index-1,curr)+1;
        break;
      }
      sbCurr.insert(i,c);
    }
    int notTake = longestStringChainHelper(dp,words,index-1,prv);
    dp.put(curr,dp.getOrDefault(curr,new HashMap<>()));
    dp.get(curr).put(prv,Math.max(take,notTake));
    return dp.get(curr).get(prv);


  }
}


class Solution_2 {

  public int longestStrChain(String[] words) {

    Arrays.sort(words, (a, b) -> a.length() - b.length());

    int[] dp = new int[words.length];
    Arrays.fill(dp,1);
    int max =1;

    for (int i = 1; i < words.length; i++) {

      String curr = words[i];
      StringBuilder sbCurr = new StringBuilder(curr);
      Set<String> set = new HashSet<>();
      for (int k = 0; k < sbCurr.length(); k++) {
        char c = sbCurr.charAt(k);
        sbCurr.delete(k,k+1);
        set.add(sbCurr.toString());
        sbCurr.insert(k,c);
      }

      for (int j = 0; j < i; j++) {
        if(words[j].length() == words[i].length()-1 && set.contains(words[j]) && dp[j]+1 > dp[i]){
          dp[i] = dp[j]+1;
          max = Integer.max(dp[i],max);
        }
      }
    }


    return max;
  }
}