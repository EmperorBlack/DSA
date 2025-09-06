package google.dnaSequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNASequenceDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
  }
}

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {

    Map<String, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for(int i =0;i< s.length();i++){

      char c = s.charAt(i);
      sb.append(c);
      if(sb.length()==10){
        String str = sb.toString();
        map.put(str, map.getOrDefault(str,0)+1);
        sb.deleteCharAt(0);
      }
    }

    for(Map.Entry<String,Integer> entry : map.entrySet()){
      if(entry.getValue() > 1){
        result.add(entry.getKey());
      }
    }
    return result;
  }
}