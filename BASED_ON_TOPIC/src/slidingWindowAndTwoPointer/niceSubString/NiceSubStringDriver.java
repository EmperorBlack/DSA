package slidingWindowAndTwoPointer.niceSubString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NiceSubStringDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public String longestNiceSubstring(String s) {

    String niceString = "";
    for(int i =0; i <s.length();i++){
      StringBuilder sb = new StringBuilder();
      Set<Character> set = new HashSet<>();
      for(int j = i;j<s.length();j++){
        char c = s.charAt(j);
        sb.append(c);
        set.add(c);

        boolean isNice = true;
        for (char ch : set){
          char cLower = Character.toLowerCase(ch);
          char cUpper = Character.toUpperCase(ch);
          if(!set.contains(cLower) || !set.contains(cUpper)){
            isNice = false;
            break;
          }
        }
        if(isNice && sb.length() > niceString.length()){
          niceString = new String(sb);
        }
      }
    }
    return niceString;
  }
}


class Solution_2 {
  public String longestNiceSubstring(String s) {


    return longest(s,0,s.length()-1);

  }

  private String longest(String sub, int left, int right){


    char[] chars = sub.toCharArray();
    Set<Character> charSet = IntStream.range(left, right+1)
        .mapToObj(i -> chars[i])
        .collect(Collectors.toSet());

    for (int i = left; i <= right ; i++) {
      char c = sub.charAt(i);
      if(!charSet.contains(Character.toLowerCase(c)) || !charSet.contains(Character.toUpperCase(c))){

        String leftNice = longest(sub,left,i-1);
        String rightNice = longest(sub,i+1,right);

        return leftNice.length() >= rightNice.length() ? leftNice : rightNice;

      }

    }

    return sub.substring(left,right+1);



  }


}