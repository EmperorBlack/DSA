package slidingWindowAndTwoPointer.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubStringDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("abba"));
  }
}

class Solution {
  public int lengthOfLongestSubstring(String s) {

    int start = 0;
    int end = 0;
    Map<Character,Integer> map = new HashMap<>();

    int max=0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(!map.containsKey(c)){
        map.put(c,i);
        end = i;
      }else{
        start = Math.max(start,map.get(c)+1);
        map.put(c,i);
        end = i;
      }

      max = Math.max(max,(end-start)+1);


    }
    return max;


  }
}
