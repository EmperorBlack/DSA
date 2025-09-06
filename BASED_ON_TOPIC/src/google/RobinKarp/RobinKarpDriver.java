package google.RobinKarp;


public class RobinKarpDriver {

  public static void main(String[] args) {


  }
}


class Solution {
  public int strStr(String haystack, String needle) {

    int mod = 10007;
    int base = 26;
    int n = needle.length();
    int m = haystack.length();

    if (n > m) return -1;

    // Precompute powers
    long[] power = new long[n];
    power[0] = 1;
    for (int i = 1; i < n; i++) {
      power[i] = (power[i - 1] * base) % mod;
    }

    // Hash for needle
    long needleHash = 0;
    for (int i = 0; i < n; i++) {
      needleHash = (needleHash + ((needle.charAt(i) - 'a' + 1) * power[n - i - 1]) % mod) % mod;
    }

    // Hash for first window of haystack
    long hayHash = 0;
    for (int i = 0; i < n; i++) {
      hayHash = (hayHash + ((haystack.charAt(i) - 'a' + 1) * power[n - i - 1]) % mod) % mod;
    }

    for (int i = n; i < m; i++) {
      if (hayHash == needleHash && haystack.substring(i - n, i).equals(needle)) {
        return i - n;
      }

      long outChar = haystack.charAt(i - n) - 'a' + 1;
      long inChar = haystack.charAt(i) - 'a' + 1;

      hayHash = (hayHash - (outChar * power[n - 1]) % mod + mod) % mod;
      hayHash = (hayHash * base) % mod;
      hayHash = (hayHash + inChar) % mod;
    }

    // Final window check
    if (hayHash == needleHash && haystack.substring(m - n).equals(needle)) {
      return m - n;
    }

    return -1;
  }
}
