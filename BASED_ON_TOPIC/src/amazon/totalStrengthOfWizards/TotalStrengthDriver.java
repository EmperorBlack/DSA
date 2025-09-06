package amazon.totalStrengthOfWizards;

import java.util.Stack;

public class TotalStrengthDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int totalStrength(int[] strength) {
    int n = strength.length;
    int MOD = 1_000_000_007;

    int[] preSmall = new int[n];
    int[] nextSmall = new int[n];

    long[] prSum = new long[n + 1];  // prefix sum
    long[] prePreSmall = new long[n + 2];  // prefix of prefix sum

    // Monotonic stack for previous smaller
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
        stack.pop();
      }
      preSmall[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }

    // Monotonic stack for next smaller
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
        stack.pop();
      }
      nextSmall[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }

    // Prefix sum and prefix of prefix sum
    for (int i = 0; i < n; i++) {
      prSum[i + 1] = (prSum[i] + strength[i]) % MOD;
      prePreSmall[i + 1] = (prePreSmall[i] + prSum[i + 1]) % MOD;
    }

    long result = 0;
    for (int i = 0; i < n; i++) {
      int l = preSmall[i];
      int r = nextSmall[i];

      int leftCount = i - l;
      int rightCount = r - i;

      long totalRight = (prePreSmall[r] - prePreSmall[i] ) % MOD;
      long totalLeft = (prePreSmall[i] - prePreSmall[l] ) % MOD;

      long total = ((totalRight * leftCount) % MOD - (totalLeft * rightCount) % MOD) % MOD;

      result = (result + total * strength[i]) % MOD;
    }

    return (int) result;
  }
}
