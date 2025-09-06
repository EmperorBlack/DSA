package google.subStringWithConcatenationSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubStringWithConcatentionDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
  }
}


class Solution {
  public List<Integer> findSubstring(String s, String[] words) {


      int wordCount = words.length;
      int wordLen = words[0].length();
      int window = wordCount*wordLen;
      int n = s.length();
      Map<String, Integer> freq = new HashMap<>();

      for (String word : words){
        freq.put(word, freq.getOrDefault(word,0)+1);
      }

      List<Integer> result = new ArrayList<>();

    for (int i = 0; i <= n-window; i++) {

      Map<String, Integer> map = new HashMap<>();
      int wordLeft = wordCount;

      for (int j = i; j < i+window; j= j+wordLen) {

        String sub = s.substring(j,j+wordLen);
        if(!freq.containsKey(sub)){
          break;
        }else{
          map.put(sub, map.getOrDefault(sub,0)+1);
          if(freq.get(sub) >= map.get(sub)){
            wordLeft--;
          }else{
            break;
          }
        }
      }

      if (wordLeft ==0){
        result.add(i);
      }



    }


      return result;

  }
}


