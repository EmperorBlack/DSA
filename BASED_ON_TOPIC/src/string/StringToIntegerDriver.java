package string;

public class StringToIntegerDriver {

  public static void main(String[] args) {

    System.out.println(Integer.MAX_VALUE);

    System.out.println(new Solution().myAtoi("2147483646"));

  }
}

class Solution {
  public int myAtoi(String s) {

    boolean isNegative = false;
    s = s.trim();
    if(s.isEmpty()){
      return 0;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {

      if(i ==0 && s.charAt(i) == '-' || i ==0 && s.charAt(i) == '+'){
        if(s.charAt(i) == '-'){
          isNegative = true;
        }
      } else if(s.charAt(i)  >= '0' && s.charAt(i)  <= '9'){
        sb.append(s.charAt(i));
      }else{
        break;
      }
    }


    int result = 0;
    int index = 0;
    while (index < sb.length()){

      int digit = Character.getNumericValue(sb.charAt(index));
//      result = (result * 10) + digit > Integer.MAX_VALUE
//      derived from this formula so that we will not go above int
      if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && (Integer.MAX_VALUE%10) < digit)){
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      result = (result * 10) + digit;
      index++;
    }


    return isNegative ? -result: result;

  }
}
