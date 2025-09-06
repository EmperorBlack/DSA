package hashing.groupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagram {

}

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {


    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {

      String s = strs[i];
      char[] sArray = s.toCharArray();
      Arrays.sort(sArray);
      String sorted = Arrays.toString(sArray);

      List<String> list = map.getOrDefault(sorted,new ArrayList<>());
      list.add(s);
      map.put(sorted,list);

    }

    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String,List<String>> m : map.entrySet() ){
      result.add(m.getValue());
    }
    return result;

  }
}
