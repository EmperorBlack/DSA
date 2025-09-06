package coutntBasic;

import java.util.HashSet;
import java.util.Set;

public class CountDigitDriver {

  public static void main(String[] args) {
    System.out.println(Solution.evenlyDivides(22074));
  }
}

class Solution{
  static int evenlyDivides(int N){

//    count of number
    int cnt = (int) (Math.log10(N) + 1);
    System.out.println(cnt);


//    Set<Integer> set = new HashSet<>();
    int num = N;
    int count = 0;
    while(num > 0){

      int digit = num % 10;
//      if(set.add(digit)){
        if(digit !=0 && N % digit == 0){
          count++;
        }
//      }
      num = num /10;
    }

    return count;
  }
}
