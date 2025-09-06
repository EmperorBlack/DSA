package slidingWindowAndTwoPointer.minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstringDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minWindow("aa","aa"));
  }
}

class Solution {
  public String minWindow(String s, String t) {


    if(s.length() < t.length()){
      return "";
    }
    Map<Character,Integer> map = new HashMap<>();

    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
    }
    int distinctChars = map.size();

    int count = 0,l = 0,min = Integer.MAX_VALUE,strInd =0;

    for (int i = 0; i < s.length(); i++) {

      char nxtChar = s.charAt(i);
      if(map.containsKey(nxtChar)){

        int frq = map.get(nxtChar);
        if(frq == 1){
          count++;
        }
        map.put(nxtChar,frq-1);
      }

      while (count == distinctChars){

        if(min > i-l+1){
          min = i-l+1;
          strInd = l;
        }

        char c = s.charAt(l);
        if(map.containsKey(c)){
          int frq = map.get(c);
          if(frq == 0){
            count--;
          }
          map.put(c,frq+1);
        }
        l++;
      }


    }
    if(min == Integer.MAX_VALUE){
      return "";
    }
    return s.substring(strInd,strInd+min);
  }
}
