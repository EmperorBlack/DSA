package array.longestPalliandrome;

import java.util.HashMap;
import java.util.Map;

public class LongestPalByChooseDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().longestPalindrome(new String[]{"lc","cl","gg"}));
  }
}

class Solution {
  public int longestPalindrome(String[] words) {



    Map<String, Integer> map = new HashMap<>();
    for(String s : words){
      map.put(s,map.getOrDefault(s,0)+1);
    }


    int count =0;
    boolean centralPresent = false;
    for(Map.Entry<String,Integer> set : map.entrySet()){

      String key = set.getKey();
      int val = set.getValue();
      if(key.charAt(0) == key.charAt(1)){

        if(val % 2 == 0){
          count = count + val;
        }else{
          count = count + val-1;
          centralPresent = true;
        }
      }else{

        String rev = key.charAt(1)+""+key.charAt(0);
        if(map.containsKey(rev)){
          count = count + (Math.min(map.get(key), map.get(rev)))*2;
          map.put(rev, 0);
          map.put(key, 0);
        }

      }


    }
    if(centralPresent){
      count++;
    }
    return 2 * count;

  }
}
