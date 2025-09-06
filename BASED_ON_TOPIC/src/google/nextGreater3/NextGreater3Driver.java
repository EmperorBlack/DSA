package google.nextGreater3;

import dp.editDistance.EditDistanceDriver;

public class NextGreater3Driver {

  public static void main(String[] args) {
    System.out.println(new Solution_2().nextGreaterElement(12));
  }
}


class Solution {
  public int nextGreaterElement(int n) {

    String[] digits = String.valueOf(n).split("");

    int len = digits.length-1;
    boolean isSwapped = false;
    for (int i = len-1 ; i >=0 && !isSwapped; i--) {
      int current = Integer.parseInt(digits[i]);
      for (int j = len; j > i   ; j--) {
        int nextGreat = Integer.parseInt(digits[j]);
        if(nextGreat > current){
          String tem = digits[i];
          digits[i] = digits[j];
          digits[j] = tem;
          isSwapped = true;

          // sort the remaining digits after the swap
          int start = i + 1;
          int end = len;
          while(start < end){
            String temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
          }
          break;
        }
      }
    }

    if(!isSwapped){
      return -1;
    }

    String result = String.join("", digits);
    long res = Long.parseLong(result);
    if(res > Integer.MAX_VALUE){
      return -1;
    }
    return (int) res;

  }
}


class Solution_2 {
  public int nextGreaterElement(int n) {

    char[] digits = String.valueOf(n).toCharArray();

    int len = digits.length-1;
    boolean isSwapped = false;
    int i = len - 1;
    for (; i >=0 && !isSwapped; i--) {

      if(digits[i] < digits[i+1]){
        for(int j = len;j> i;j--){
          if(digits[j] > digits[i]){
            swap(digits, i, j);
            isSwapped = true;

            // sort the remaining digits after the swap
            int start = i + 1;
            int end = len;
            while(start < end){
              swap(digits, start, end);
              start++;
              end--;
            }
            break;

          }
        }

      }
    }
    if(!isSwapped){
      return -1;
    }

    String result = String.valueOf(digits);
    long res = Long.parseLong(result);
    if(res > Integer.MAX_VALUE){
      return -1;
    }
    return (int) res;

  }

  private void swap(char[] digits, int i, int j) {
    char temp = digits[i];
    digits[i] = digits[j];
    digits[j] = temp;
  }
}