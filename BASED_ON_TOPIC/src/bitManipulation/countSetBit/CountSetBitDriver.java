package bitManipulation.countSetBit;

import java.util.Arrays;

public class CountSetBitDriver {

  public static void main(String[] args) {

    System.out.println(Solution_2.countSetBits(11));
  }
}

class Solution{

  //Function to return sum of count of set bits in the integers from 1 to n.
  public static int countSetBits(int n){

    int count = 0;
    for (int i = 1; i <= n; i++) {

      int m = i;
      int temp = 0;
      while (m!=0){
        temp = temp + (m&1);
        m = m>>1;
      }
      count = count + temp;
    }
    return count;
  }
}

class Solution_1{

  //Function to return sum of count of set bits in the integers from 1 to n.
  public static int countSetBits(int n){

    int dp[] = new int[n+1];
    Arrays.fill(dp,-1);

    int count = 0;
    for (int i = 1; i <= n; i++) {

      int m = i;
      int temp = 0;
      while (m!=0){
        m=m&(m-1);
        temp++;
        if(dp[m] != -1){
          temp = temp+dp[m];
          break;
        }
      }
      dp[i] = temp;
      count += temp;
    }
    return count;
  }
}

class Solution_2{

  //Function to return sum of count of set bits in the integers from 1 to n.
  public static int countSetBits(int n) {

    if(n == 0){
      return 0;
    }
    int x = getLargestPower(n);
    int bitsUpto2raiseXminusOne = x * (1<<(x-1));
    int leftMostBitCount = n - (1<<x) +1;
    return bitsUpto2raiseXminusOne + leftMostBitCount + countSetBits(n-(1<<x));
  }

  private static int getLargestPower(int n){
    int x =0;
    while ((1<<x) <= n){
      x++;
    }
    return x-1;
  }
}