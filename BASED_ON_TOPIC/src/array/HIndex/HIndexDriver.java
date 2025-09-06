package array.HIndex;

public class HIndexDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().hIndex(new int[]{1}));
  }
}


class Solution {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int low = 0, high = n - 1;
    int result = 0;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int h = n - mid;

      if (citations[mid] >= h) {
        result = h;        // This h is a valid candidate
        high = mid - 1;    // Try to find a higher h with fewer papers
      } else {
        low = mid + 1;
      }
    }

    return result;
  }
}
