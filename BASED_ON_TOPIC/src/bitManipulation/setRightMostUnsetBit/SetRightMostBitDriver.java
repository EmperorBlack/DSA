package bitManipulation.setRightMostUnsetBit;

public class SetRightMostBitDriver {

  public static void main(String[] args) {

  }

}
class Solution {
  static int setBit(int n) {
    return n | (n+1);
  }
}