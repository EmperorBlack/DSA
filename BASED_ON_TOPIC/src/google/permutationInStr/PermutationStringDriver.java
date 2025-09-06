package google.permutationInStr;

import java.util.HashMap;
import java.util.Map;

public class PermutationStringDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));
  }
}


class Solution {
  public boolean checkInclusion(String s1, String s2) {

    Map<Character,Integer> map = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
    }

    int s1Len = s1.length();
    int count = 0;

    Map<Character,Integer> window = new HashMap<>();
    int l =0;
    for(int i = 0;i< s2.length();i++){

      char c = s2.charAt(i);
      window.put(c,window.getOrDefault(c,0)+1);

      if(map.containsKey(c) && window.get(c) <= map.get(c)){
        count++;
      }

      if(i-l >= s1Len){
        char leftChar = s2.charAt(l++);
        if(map.containsKey(leftChar)){
          if(window.get(leftChar) <= map.get(leftChar)){
            count--;
          }
        }
        window.put(leftChar,window.get(leftChar)-1);
//        if(window.get(leftChar) == 0){
//          window.remove(leftChar);
//        }
      }
      if(count == s1Len){
        return true;
      }
    }
    
    
    return false;
  }
}