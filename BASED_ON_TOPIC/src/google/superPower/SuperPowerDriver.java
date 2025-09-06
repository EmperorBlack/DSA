package google.superPower;

public class SuperPowerDriver {

  public static void main(String[] args) {

    StringBuilder s = new StringBuilder();
    s.substring(0,2);
    s.replace(0,2,"");
    System.out.println(s.toString());
  }
}

// a^123 = a^(100*1 + 10*2 + 3) = a^(a^1 * a^2 * a^3)
//  a^123 =  (a^12)^10 * a^3
//  a^12 = (a^1)^10 * a^2
//  a^1 =  1^10 * a^1
class Solution {
  public int superPow(int a, int[] b) {

    if(a == 0 || a == 1){
      return a;
    }
    int mod = 1337;
    a = a % mod;
    return helper(a, b, b.length - 1, mod);

  }

  private int helper(int a, int[] b, int index,int mod){

    if(index < 0){
      return 1;
    }

    int lastDigit = b[index];
    int partialResult = helper(a, b, index - 1, mod);
    int part1 = powMod(a,lastDigit);
    int part2 = powMod(partialResult,10);

    return part1 * part2 % mod;

  }

  private int powMod(int a, int b){
    int mod = 1337;
    a = a%mod;
    int result = 1;
    for (int i = 0; i < b; i++) {
      result = (result * a) % mod;
    }
    return result;
  }
}



