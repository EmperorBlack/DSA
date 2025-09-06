package string.BeautyOfAllSubString;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BeautyOfAllSubstringDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().beautySum("aabcbaa"));
  }
}

class Solution {
  public int beautySum(String s) {

    int count =0;
    for (int i = 0; i < s.length(); i++) {


      Map<Character,Integer> map = new HashMap();
      for (int j = i; j < s.length(); j++) {

        char c = s.charAt(j);
        map.put(c, map.getOrDefault(c,0)+1);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character,Integer> entry : map.entrySet()){
          min = Math.min(min,entry.getValue());
          max = Math.max(max, entry.getValue());
        }

          count += max-min;


      }
    }
    return count;

  }
}
