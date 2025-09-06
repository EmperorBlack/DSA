package slidingWindowAndTwoPointer.subArrayWithKdistinctChars;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctCharDriver {

  public static void main(String[] args) {

    System.out.println(Solution.kDistinctChars(3,"aaaaaaaa"));
  }
}

 class Solution {

  public static int kDistinctChars(int k, String str) {

    Map<Character,Integer> map = new HashMap<>();
    int l =0;
    int maxStr = 0;

    for (int i = 0; i < str.length(); i++) {

      char c = str.charAt(i);
      map.put(c, map.getOrDefault(c,0)+1);

      if(map.size() <= k){
        maxStr = Math.max(maxStr,(i-l+1));
      }

      if(map.size() > k){
        map.put(str.charAt(l),map.get(str.charAt(l))-1);
        if(map.get(str.charAt(l)) ==0){
          map.remove(str.charAt(l));
        }
        l++;
      }

    }
    return maxStr;
  }

}
