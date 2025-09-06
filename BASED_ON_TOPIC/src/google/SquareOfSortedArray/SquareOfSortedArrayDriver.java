package google.SquareOfSortedArray;

import java.util.Arrays;

public class SquareOfSortedArrayDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().multiply("123","456"));

  }
}

class Solution {

public String multiply(String num1, String num2) {

  if(num1.equals("0") || num2.equals("0")){
    return "0";
  }

  String sum = "";
  int offset = 0;
  for(int i =num2.length()-1;i>=0;i--){
    String mul = multiply(num1, Character.getNumericValue(num2.charAt(i)));
    if(sum.isEmpty()){
      sum = mul;
    }else{
      sum = caluclateSumOfTwo(sum, mul,offset);
    }
    offset++;
  }
  return sum;
}

private String multiply(String num1, int x){
  if(x==0){
    return "0";
  }
  StringBuilder sb = new StringBuilder();
  int index = num1.length()-1;
  int carry =0;
  while(index>=0){
    int a = Character.getNumericValue(num1.charAt(index--));
    int mul = (a*x)+carry;
    sb.insert(0,mul%10);
    carry = mul/10;
  }
  if(carry > 0){
    sb.insert(0,carry);
  }
  return sb.toString();


}

private String caluclateSumOfTwo(String num1, String num2, int offSet){

  int iIndex = num1.length()-1;
  StringBuilder sb = new StringBuilder();
  while(offSet >0){
    sb.insert(0,num1.charAt(iIndex--));
    offSet--;
  }

  int jIndex = num2.length()-1;

  int carry = 0;
  while(iIndex >=0 || jIndex >=0){
    int a = iIndex >=0 ? Character.getNumericValue(num1.charAt(iIndex--)) : 0;
    int b = jIndex >=0 ? Character.getNumericValue(num2.charAt(jIndex--)) : 0;
    int sum = a+b+carry;
    sb.insert(0,sum%10);
    carry = sum/10;
  }
  if(carry > 0){
    sb.insert(0,carry);
  }
  return sb.toString();
  }
}

