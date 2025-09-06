package randomPractice.pow;

public class PowDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public double myPow(double x, int n) {

    double powValue = myPowHelper(x,n);
    if(n < 0){
      return 1/powValue;
    }
    return powValue;

  }

  public double myPowHelper(double x, int n){

    if(n == 0) {
      return 1;
    }

    double value = myPowHelper(x, n/2);
    if(n %2 ==0){
      return value*value;
    }else{
      return value*value*x;
    }

  }
}
