package bitManipulation.minBitFlip;

public class MinBitFlipDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().minBitFlips(10,7));
  }
}


class Solution {
  public int minBitFlips(int start, int goal) {


    int count =0;
    while (start != 0 || goal != 0){
      count = count + ((start & 1) ^ (goal & 1));
      start >>= 1;
      goal >>=1;
    }
    return count;
  }
}
