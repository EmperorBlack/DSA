package google.shortestPalindrome;

public class ShortestPalindromeDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().shortestPalindrome("aacecaaa"));
  }
}

class Solution {
  public String shortestPalindrome(String s) {

    int min = Integer.MAX_VALUE;
    String res= "";
    for (int i = 0; i < s.length(); i++) {
      StringBuilder result = makePalliandrome(s, i,i);
      if(result.length() >= s.length()){
        if(result.length() < min){
          min = result.length();
          res = result.toString();
        }
      }
    }

    for (int j = 1; j < s.length(); j++) {
      int i = j-1;
      if(s.charAt(i) == s.charAt(j)){
        StringBuilder result = makePalliandrome(s, i,j);
        if(result.length() >= s.length()){
          if(result.length() < min){
            min = result.length();
            res = result.toString();
          }
        }
      }
    }
    return res;
  }


  private StringBuilder makePalliandrome(String s, int i, int j){

    StringBuilder sb = new StringBuilder();
    if(i ==j){
      sb.append(s.charAt(i));
    }else{
      sb.append(s.charAt(i));
      sb.append(s.charAt(j));
    }

    int l = i-1;
    for(int r = j+1;r< s.length();r++){

      sb.append(s.charAt(r));
      if(l < 0){
        char c = s.charAt(r);
        sb.insert(0,c);
        l--;
      } else {
        if(s.charAt(l) == s.charAt(r)){
          char c = s.charAt(r);
          sb.insert(0,c);
          l--;
        } else {
          break;
        }
      }
    }
    return sb;
  }
}
