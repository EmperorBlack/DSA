package string.longestPalliandromicSubstring;

public class LongestPalliandromicSubStringDriver {


  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("cbbd"));
  }
}


class Solution {
  static int max = -1;
  static int iMax = Integer.MAX_VALUE;
  static int jMax = Integer.MIN_VALUE;
  public String longestPalindrome(String s) {
    max = -1;
    iMax = Integer.MAX_VALUE;
    jMax = Integer.MIN_VALUE;

    for (int i = 0; i < s.length(); i++) {

      longestSubString(s,i,i);
      longestSubString(s,i,i+1);
    }
    return s.substring(iMax,jMax+1);
  }

  private void longestSubString(String s , int i, int j){

    while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
      if(j-i+1 > max){
        max = j-i+1;
        iMax = i;
        jMax = j;
      }
      i--;
      j++;
    }
  }
}