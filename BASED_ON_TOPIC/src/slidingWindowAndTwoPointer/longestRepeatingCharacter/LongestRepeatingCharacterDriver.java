package slidingWindowAndTwoPointer.longestRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestRepeatingCharacterDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().characterReplacement("AABABBA",1));
  }
}
class Solution {
  public int characterReplacement(String s, int k) {


    int maxLen = 0;
    int maxFreq = 0;
    Map<Character,Integer> map = new HashMap<>();

    int start = 0;

    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);
      if(!map.containsKey(c)){
        map.put(c,1);
      }else{
        map.put(c,map.get(c)+1);
      }

      maxFreq = Math.max(maxFreq,map.get(c));
      if(((i-start+1)- maxFreq) <= k){// checking how many character we need to change by leaving ma freq character
        maxLen = Math.max(maxLen,i-start+1);
      }else{
        map.put(s.charAt(start),map.get(s.charAt(start))-1);
//        for (Map.Entry<Character,Integer> entry:map.entrySet()){
//          maxFreq = Math.max(maxFreq,entry.getValue());
//        }
        start++;
      }


    }
    return maxLen;

  }
}

//scanning to get lower frequency not need ,
//As previously  we see if we have seen a result at frequncy 3,
//then there will not chance that lower frequency will provide us max result, so
//if better frequency will come we can get that