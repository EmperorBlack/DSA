package bitManipulation.XorFromLToR;

public class XorFromLToRDriver {

  public static void main(String[] args) {

    System.out.println(Solution.findXOR(4,8));
  }
}

class Solution {
  public static int findXOR(int l, int r) {

//    from 1 to l
    int OneToL = findXorFromOneToN(l-1);
    int oneToR = findXorFromOneToN(r);
    return OneToL ^ oneToR;


  }

  public static int findXorFromOneToN(int n){

    if(n % 4 ==0){
      return n;
    } else if (n % 4 == 3) {
      return 0;
    } else if (n % 4 == 2) {
      return n+1;
    } else  {
      return 1;
    }
  }
}
