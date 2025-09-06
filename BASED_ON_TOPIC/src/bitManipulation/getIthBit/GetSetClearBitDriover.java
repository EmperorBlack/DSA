package bitManipulation.getIthBit;

public class GetSetClearBitDriover {

  public static void main(String[] args) {

//    Solution.bitManipulation(70, 3);
    System.out.println(~(5));
  }
}

class Solution {
  static void bitManipulation(int num, int i) {
    // code here

    System.out.print((num >> (i-1)) & 1);

    System.out.print(" " + (num | 1 << i-1));

    System.out.print(" " + (num & ~(1 << i-1)));

  }
}
