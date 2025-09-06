package recursion.letterCombination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationDriver {

  public static void main(String[] args) {

//    System.out.println(new Solution().letterCombinations("23"));

    Integer a = 1;
    Integer b = 1;
    System.out.println(a.equals(b));
  }
}

class Solution {
  public List<String> letterCombinations(String digits) {
    if(digits.isEmpty()){
      return new ArrayList<>();
    }

    String[] ltr = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    List<String> result = new ArrayList<>();
    letterCombinations(digits,0,ltr,new StringBuilder(),result);
    return result;


  }

  public void letterCombinations(String digits, int index, String[] ltr, StringBuilder sb, List<String> result) {

    if(index >= digits.length()){
      result.add(new String(sb));
      return ;
    }

    int dig = digits.charAt(index)-'0';
    String chars = ltr[dig-2];
    for (int i = 0; i < chars.length(); i++) {
      sb.append(chars.charAt(i));
      letterCombinations(digits,index+1,ltr,sb,result);
      sb.deleteCharAt(sb.length()-1);
    }

  }
}
