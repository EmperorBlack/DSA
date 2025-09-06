package slidingWindowAndTwoPointer.sequentialDigit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigitDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().sequentialDigits(100,300));
  }
}


class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> result = new ArrayList<>();

    // Start from each digit from 1 to 9
    for (int start = 1; start <= 9; start++) {
      int num = start;
      int next = start;

      // Keep appending next sequential digits until num exceeds high or next > 9
      while (num <= high && next < 10) {
        if (num >= low) {
          result.add(num);
        }
        next++;
        num = num * 10 + next;
      }
    }

    Collections.sort(result); // Sort the result list
    return result;
  }
}
