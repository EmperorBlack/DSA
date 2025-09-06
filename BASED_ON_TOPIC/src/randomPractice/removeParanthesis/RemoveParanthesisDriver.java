package randomPractice.removeParanthesis;

import java.util.Arrays;

public class RemoveParanthesisDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public String removeOuterParentheses(String s) {

    if(s == null || s.isEmpty()){
      return "";
    }

    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '('){
        if(count > 0){
          sb.append('(');
        }
        count++;
      }else {
        if(count > 1){
          sb.append(')');
        }
        count--;
      }

    }
    return sb.toString();

  }
}

class Solution_1 {
  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()){
      return false;
    }

    char[] s1 = s.toCharArray();
    char[] s2 = t.toCharArray();

    Arrays.sort(s1);
    Arrays.sort(s2);

    return String.valueOf(s1).equals(String.valueOf(s2));


  }
}

