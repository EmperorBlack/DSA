package recursion;

public class AtoiRecursion {

  public static void main(String[] args) {

    System.out.println(new Solution().myAtoi("    -42"));
  }
}

class Solution {
  static boolean isNegative;
  public int myAtoi(String s) {

    isNegative = false;
    s = s.trim();
    if(s.isEmpty()){
      return 0;
    }

    int index = 0;
      if(s.charAt(index) == '-'){
        isNegative = true;
        index++;
      }else if(s.charAt(index) == '+'){
        index++;
      }
    StringBuilder result = new StringBuilder();
      getNumericString(s,result,index);
    return getNumericValue(result,0,0);

  }

  public void getNumericString(String s, StringBuilder result,int index){

    if(index >= s.length()){
      return;
    }

    if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
      result.append(s.charAt(index));
      getNumericString(s,result,index+1);
    }
  }

  public int getNumericValue(StringBuilder sb, int index,int result){

    if(index >= sb.length()){
      return isNegative ? -result:result;
    }

    int digit = Character.getNumericValue(sb.charAt(index));
    if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && (Integer.MAX_VALUE%10) < digit)){
      return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }else{
      return getNumericValue(sb,index+1,(result*10) + digit);
    }
  }
}
