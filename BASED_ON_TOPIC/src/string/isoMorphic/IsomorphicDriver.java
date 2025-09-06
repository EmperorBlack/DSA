package string.isoMorphic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().isIsomorphic("aaa","aaa"));
  }
}

class Solution {
  public boolean isIsomorphic(String s, String t) {

    Map<Character,Character> map = new HashMap<>();
    Set<Character> set = new HashSet<>();
    int i = 0;
    while (i < s.length()){

      if(map.containsKey(s.charAt(i))){
        if(map.get(s.charAt(i))!=t.charAt(i)){
          return false;
        }
      }else{
        if(set.contains(t.charAt(i))){
          return false;
        }
        map.put(s.charAt(i),t.charAt(i));
        set.add(t.charAt(i));

      }
      i++;
    }
    return true;
  }

  public boolean isIsomorphic_2(String s, String t) {

    int[] map1 = new int[256];
    int[] map2 = new int[256];

    for (int i = 0; i < s.length(); i++) {

      if(map1[s.charAt(i)] != map2[t.charAt(i)]){
        return false;
      }

      map1[s.charAt(i)] = i+1;
      map2[t.charAt(i)] = i+1;

    }
    return true;
  }

}
