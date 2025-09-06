package bitManipulation.devideTwoNumberBit;

public class DevideNumberDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().divide(-2147483648,-1));
  }
}


class Solution {
  public int divide(int dividend, int divisor) {
    // Special case: overflow when dividend is Integer.MIN_VALUE and divisor is -1
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE; // Overflow case
    }

    // Determine the sign of the result
    boolean sign = (dividend < 0) == (divisor < 0);

    // Use long to handle edge cases like Integer.MIN_VALUE
    long absDiv = Math.abs((long) dividend);
    long absDivisor = Math.abs((long) divisor);

    int result = 0;

    // Use bit shifting to efficiently calculate the quotient
    while (absDiv >= absDivisor) {
      long tempDivisor = absDivisor, multiple = 1;

      // Increase the divisor by powers of two until it's greater than dividend
      while (absDiv >= (tempDivisor << 1)) {
        tempDivisor <<= 1;
        multiple <<= 1;
      }

      // Subtract the largest shifted divisor from the dividend
      absDiv -= tempDivisor;
      result += multiple;
    }

    // Apply the sign to the result
    return sign ? result : -result;
  }
}
