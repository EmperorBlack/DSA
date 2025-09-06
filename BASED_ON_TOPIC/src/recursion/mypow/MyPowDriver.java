package recursion.mypow;

public class MyPowDriver {


  public static void main(String[] args) {

    System.out.println(new Solution().myPow(0.00001,2147483647));
  }
}


class Solution {
  public double myPow(double x, int n) {

    double result = myPowHelper(x,Math.abs(n));
    if(n < 0){
        return 1/result;
    }else{
      return result;
    }
  }

  public double myPowHelper(double x, int n){
    if(n ==0){
      return 1;
    }
    double half =  myPowHelper(x,n/2);
    if(n%2 == 0){
      return half*half;
    }else{
      return half*half*x;
    }
  }
}