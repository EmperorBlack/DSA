package string.rotateString;

public class RotateStringDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().rotateString("abcde","cdeab"));
  }
}

class Solution {
  public boolean rotateString(String s, String goal) {

    StringBuilder sb = new StringBuilder(s);
    for(int i = 0; i< s.length();i++){
      sb.append(sb.charAt(0));
      sb.deleteCharAt(0);
      if(sb.toString().equals(goal)){
        return true;
      }
    }
  return false;
  }

  public boolean rotateString_2(String s, String goal) {

    if(s.length() != goal.length()){
      return false;
    }
    String s1 = s+s;
    return s1.contains(goal);
  }
}