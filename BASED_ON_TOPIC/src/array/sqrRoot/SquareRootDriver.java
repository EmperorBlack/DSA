package array.sqrRoot;

public class SquareRootDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().mySqrt(8));
    System.out.println(2^3);
  }
}

class Solution {
  static long sqrtElemnt = -1;
  public int mySqrt(int x) {
    sqrtElemnt = -1;

    int upBound = x;

    floorBS(x,0,upBound);
    return (int)sqrtElemnt;



  }

  public void floorBS(int x ,int i, int j){

    if(i>j){
      return;
    }

    long mid = i + (j-i)/2;
    if((mid * mid) ==  x){
      sqrtElemnt = mid;
      return;
    } else if ((mid * mid) >  x) {
      floorBS(x,i,(int)mid-1);
    }else{
      sqrtElemnt = mid;
      floorBS(x,(int)mid+1,j);

    }
  }
}
