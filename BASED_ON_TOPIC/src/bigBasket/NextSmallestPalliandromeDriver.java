package bigBasket;

public class NextSmallestPalliandromeDriver {

  public static void main(String[] args) {

  }
}

class Solution {

  public static String nextLargestPalindrome(String number, int length) {
    if (isPalindrome(number)) {
      number = addOne(number);
      return nextLargestPalindrome(number, number.length());
    }

    return (number.length() % 2 == 0) ? handleEven(number) : handleOdd(number);
  }

  private static boolean isPalindrome(String num) {
    int i = 0, j = num.length() - 1;
    while (i < j) {
      if (num.charAt(i) != num.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  private static String addOne(String num) {
    StringBuilder sb = new StringBuilder(num);
    int carry = 1;

    for (int i = sb.length() - 1; i >= 0 && carry > 0; i--) {
      int digit = sb.charAt(i) - '0' + carry;
      carry = digit / 10;
      sb.setCharAt(i, (char) ('0' + digit % 10));
    }

    if (carry > 0) {
      sb.insert(0, '1');
    }

    return sb.toString();
  }

  private static String handleEven(String num) {
    int n = num.length();
    String left = num.substring(0, n / 2);
    String right = num.substring(n / 2);
    String candidate = left + new StringBuilder(left).reverse();

    if (compare(candidate, num) > 0) {
      return candidate;
    } else {
      left = addOne(left);
      return left + new StringBuilder(left).reverse().toString();
    }
  }

  private static String handleOdd(String num) {
    int n = num.length();
    String left = num.substring(0, n / 2);
    String mid = num.substring(n / 2, n / 2 + 1);
    String right = num.substring(n / 2 + 1);
    String candidate = left + mid + new StringBuilder(left).reverse();

    if (compare(candidate, num) > 0) {
      return candidate;
    } else {
      String leftPlusMid = left + mid;
      leftPlusMid = addOne(leftPlusMid);
      String newLeft = leftPlusMid.substring(0, leftPlusMid.length() - 1);
      String newMid = leftPlusMid.substring(leftPlusMid.length() - 1);
      return newLeft + newMid + new StringBuilder(newLeft).reverse().toString();
    }
  }

  // Lexicographic string comparison without conversion
  private static int compare(String a, String b) {
    if (a.length() != b.length()) {
      return Integer.compare(a.length(), b.length());
    }
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        return a.charAt(i) - b.charAt(i);
      }
    }
    return 0;
  }
}
