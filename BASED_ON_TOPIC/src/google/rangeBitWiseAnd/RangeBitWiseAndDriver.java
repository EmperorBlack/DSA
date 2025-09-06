package google.rangeBitWiseAnd;

public class RangeBitWiseAndDriver {

  public static void main(String[] args) {

//    int result = 1;
//    for (int i = 1; i < 7; i++) {
//      result = result & i;
//      System.out.println(result);
//    }

    System.out.println(new Solution().canTransform("XLLR","LXLX"));


  }

  void method(int a){
    a = 4;
  }
}


class Solution {
  public boolean canTransform(String start, String result) {

    for (int i = 0; i < start.length(); i++) {

      if(start.charAt(i) != result.charAt(i)){

        if(i == start.length()-1){
          return start.charAt(start.length()-1) == result.charAt(start.length()-1);
        }

        if(start.charAt(i) =='X' && start.charAt(i+1) == 'L' && result.charAt(i) =='L' && result.charAt(i+1) == 'X'){
          i++;
        } else if (start.charAt(i) =='R' && start.charAt(i+1) == 'X' && result.charAt(i) =='X' && result.charAt(i+1) == 'R') {
          i++;
        }else{
          return false;
        }

      }

    }
    return true;

  }
}