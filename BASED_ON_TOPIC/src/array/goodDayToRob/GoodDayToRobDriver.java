package array.goodDayToRob;

import java.util.ArrayList;
import java.util.List;

public class GoodDayToRobDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().goodDaysToRobBank(new int[]{5,3,3,3,5,6,2},2));
  }
}


class Solution {
  public List<Integer> goodDaysToRobBank(int[] security, int time) {


    int[] fromLeft = new int[security.length];
    int[] fromRight = new int[security.length];

    int leftDec = 0;
    int rightDec =0;

    for (int i = 1; i < security.length; i++) {

      if(security[i] <= security[i-1]){
        leftDec++;
      }else {
        leftDec =0;
      }
      fromLeft[i] = leftDec;

      int right = security.length-1-i;

      if(security[right] <= security[right+1] ){
        rightDec++;
      }else{
        rightDec=0;
      }

      fromRight[right] =rightDec;
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < security.length; i++) {

      if(fromLeft[i] >= time && fromRight[i] >= time){
        list.add(i);
      }
    }
    return list;


  }



}