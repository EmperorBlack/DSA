package string.removeOuterParanthesis;

public class RemoveOuterParanthesisDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().removeOuterParentheses_2("(()())(())"));
//
//    int i =0;
//    System.out.println(i++ <= 0);



  }
}

class Solution {
  public String removeOuterParentheses(String s) {

    if (s == null || s.isEmpty()){
      return "";
    }

    StringBuilder result = new StringBuilder();
    StringBuilder temp = new StringBuilder();

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '('){
        count++;
      }else {
        count--;
      }
      temp.append(s.charAt(i));

      if(count == 0){
//        if(temp.length() > 2){
          result.append(temp.substring(1,temp.length()-1));
//        }
        temp = new StringBuilder();
      }
    }
    return result.toString();

  }

  public String removeOuterParentheses_2(String s) {

    if (s == null || s.isEmpty()){
      return "";
    }

    StringBuilder result = new StringBuilder();

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '('){
        if(count > 0){
          result.append('(');
        }
        count++;
      }else {
        if(count > 1){
          result.append(')');
        }
        count--;
      }

    }
    return result.toString();

  }
}
