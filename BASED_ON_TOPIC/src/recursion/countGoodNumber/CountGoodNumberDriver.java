package recursion.countGoodNumber;

public class CountGoodNumberDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().countGoodNumbers(1));

  }
}

// for one (there is only we can place even element from 0,2,4,6,8 out of 5 we can place one (5C1))
class Solution {
  static long mod = 1000000007;
  public int countGoodNumbers(long n) {


    long odd = n/2;
    long even = (n/2) + (n%2);

    return (int)((pow(5,even) * pow(4,odd))%mod);



  }

  private long pow(int x, long n){

    if(n == 0){
      return 1;
    }

    long half = pow(x,n/2);

    if(n%2 == 0){
      return (half*half)%mod;
    }else{
      return (half*half*x)%mod;
    }
  }
}