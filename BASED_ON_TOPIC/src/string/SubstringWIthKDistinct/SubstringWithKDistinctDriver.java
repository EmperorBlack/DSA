package string.SubstringWIthKDistinct;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithKDistinctDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().countSubstr("aba",2));
  }
}




class Solution {
  int countSubstr(String str, int k) {
    // Count the substrings with exactly k distinct characters
    return countSubStrK(str, k)- countSubStrK(str,k-1);
  }

  public int countSubStrK(String str, int k) {
    // Edge case: if k is 0 or the string is empty, return 0
    if (k == 0 || str.isEmpty()) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    int i = 0;  // Start index of the window
    int j = 0;  // End index of the window
    int count = 0; // Count of valid substrings

    while (j < str.length()) {
      // Expand the window by adding characters from the right
      char c = str.charAt(j);
      map.put(c, map.getOrDefault(c, 0) + 1);
      j++;

      // While we have more than k distinct characters, shrink from the left
      while (map.size() > k) {
        char leftChar = str.charAt(i);
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(leftChar) == 0) {
          map.remove(leftChar);
        }
        i++; // Move left index to shrink the window
      }

      // Now map.size() <= k
      // Add all valid substrings ending at j-1 and starting from i to j-1
      count += j - i; // This is the number of valid substrings
    }

    return count;
  }



}
