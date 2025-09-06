package slidingWindowAndTwoPointer.numberOfSubStrAllChars;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubContainAllCharDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().numberOfSubstrings("abcabc"));
  }
}

class Solution {
  public int numberOfSubstrings(String s) {


    int l =0;
    int r =0;
    int count =0;
    Map<Character,Integer> map = new HashMap<>();
    while (r < s.length()){

      map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);

      while (map.size() >= 3){
        count= count+ s.length()-r;
        char c = s.charAt(l);
        map.put(c, map.get(c)-1);
        if(map.get(c) == 0){
          map.remove(c);
        }
        l++;
      }
      r++;
    }
    return count;

  }
}
