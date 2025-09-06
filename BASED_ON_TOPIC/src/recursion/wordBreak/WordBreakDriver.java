package recursion.wordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakDriver {

  public static void main(String[] args) {

    List<String> list = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
    System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",list));
  }
}

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {


    Set<String> set = new HashSet<>(wordDict);

    Map<Integer,Boolean> dp = new HashMap<>();


    return isWordBreak(s,set,0,dp);
  }

  public boolean isWordBreak(String s, Set<String> dictionary, int start, Map<Integer,Boolean> dp) {

    if(dp.containsKey(start)){
      return dp.get(start);
    }
    if(start >= s.length()){
      return true;
    }

    for (int i = start; i < s.length(); i++) {
      String sub = s.substring(start,i+1);
      if(dictionary.contains(sub) && isWordBreak(s,dictionary,i+1,dp)){
        dp.put(start,true);
        return true;
      }
    }
    dp.put(start,false);
    return false;

  }



}

class Solution_2WB2 {
  public List<String> wordBreak(String s, List<String> wordDict) {


    Set<String> set = new HashSet<>(wordDict);


    List<String> result = new ArrayList<>();

     isWordBreak(s,set,0,new ArrayList<>(),result);
     return result;

  }

  public void isWordBreak(String s, Set<String> dictionary, int start, List<String> temp, List<String> result) {


    if(start >= s.length()){
      result.add(String.join(" ", temp));
    }

    for (int i = start; i < s.length(); i++) {
      String sub = s.substring(start,i+1);
      if(dictionary.contains(sub)){

        temp.add(sub);
        isWordBreak(s,dictionary,i+1,temp,result);
        temp.remove(temp.size()-1);
      }
    }

  }



}


class Solution_WB2_DP{
  public List<String> wordBreak(String s, List<String> wordDict) {


    Set<String> set = new HashSet<>(wordDict);

    Map<Integer,List<String>> dp = new HashMap<>();

    List<String> result = new ArrayList<>();

    return  isWordBreak(s,set,0,dp);

  }

  public List<String> isWordBreak(String s, Set<String> dictionary, int start, Map<Integer,List<String>> dp) {

    if(dp.containsKey(start)){
      return dp.get(start);
    }

    List<String> subResult = new ArrayList<>();
    if(start >= s.length()){
      subResult.add("");
      return subResult;
    }

    for (int i = start; i < s.length(); i++) {
      String sub = s.substring(start,i+1);
      if(dictionary.contains(sub)){

        List<String> subSentence = isWordBreak(s,dictionary,i+1,dp);
        for (String subStr : subSentence){
          if(subStr.isEmpty()){
            subResult.add(sub);
          }else {
            subResult.add(sub+ " " +subStr);
          }
        }

      }
    }
    dp.put(start,subResult);
    return subResult;

  }



}






