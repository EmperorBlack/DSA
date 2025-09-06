package bitManipulation.powerOf2;

public class PowerOf2Driver {

  public static void main(String[] args) {

  }
}

class Solution {
  public boolean isPowerOfTwo(int n) {

    if(n<=0){
      return false;
    }
    if(n <= 2 ){
      return true;
    }

    while (n>2){
      if(n%2 == 1){
        return false;
      }
      n = n/2;

    }
    return true;
  }
}

class Solution_2 {
  public boolean isPowerOfTwo(int n) {

    if(n <=0){
      return false;
    }

    while(n%2 == 0){
      n = n/2;
    }

    return n ==1;
  }
}

class Solution_3 {
  public boolean isPowerOfTwo(int n) {

    if(n <=0){
      return false;
    }

   return  (n & n-1) == 0;
  }
}




