package array.movePicesToObtainString;

public class MovePicesToObtainStrDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().canChange("_L__R__R_","L______RR"));
  }
}

class Solution {
  public boolean canChange(String start, String target) {
    int n = start.length();
    int l = 0, r = 0;

    while (l < n || r < n) {
      // Skip underscores
      while (l < n && start.charAt(l) == '_') l++;
      while (r < n && target.charAt(r) == '_') r++;

      // If both reach end, done
      if (l == n && r == n) return true;

      // One reached end, other didn’t — invalid
      if (l == n || r == n) return false;

      // Check character match
      if (start.charAt(l) != target.charAt(r)) return false;

      // Movement rules
      char ch = start.charAt(l);
      if (ch == 'L' && l < r) return false;
      if (ch == 'R' && l > r) return false;

      l++;
      r++;
    }

    return true;
  }
}
