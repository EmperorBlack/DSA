package stackQueue.maxSwap;

import java.util.Arrays;
import java.util.Stack;

public class MaxSwapDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().maximumSwap(98368));
  }
}

class Solution {
  public int maximumSwap(int num) {

    String[] numArr = String.valueOf(num).split("");
    int[] nextBig = new int[numArr.length];
    nextBig[numArr.length-1] = -1;
    int bigIndex = numArr.length-1;
    for(int i = numArr.length-2;i>=0;i--){

      if(Integer.parseInt(numArr[i]) <= Integer.parseInt(numArr[bigIndex])){
        nextBig[i] = bigIndex;
      }else{
        nextBig[i] = -1;
        bigIndex = i;
      }
    }

    for(int i =0;i<numArr.length;i++){
      if(nextBig[i] != -1 && Integer.parseInt(numArr[i]) != Integer.parseInt(numArr[nextBig[i]])){
        String temp = numArr[i];
        numArr[i] = numArr[nextBig[i]];
        numArr[nextBig[i]] = temp;
        break;
      }
    }


    return Integer.parseInt(String.join("",numArr));




  }
}
