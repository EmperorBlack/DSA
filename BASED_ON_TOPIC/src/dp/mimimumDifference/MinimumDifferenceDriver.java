package dp.mimimumDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumDifferenceDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minimumDifference(new int[]{-36,36}));
  }
}

class Solution {
  public int minimumDifference(int[] nums) {

    int m = nums.length;
    int sum =0;
    for (int num : nums){
      sum += num;
    }

    boolean dp[][] = new boolean[m][sum+1];

    for (int i = 0; i < m; i++) {
      dp[i][0] = true;
    }

    if(nums[0] <= sum){
      dp[0][nums[0]] = true;
    }

    for (int index = 1; index < m; index++) {

      for (int target = 1; target < sum+1 ; target++) {

        boolean take = false;
        if(target >= nums[index]){
          take = dp[index-1][target-nums[index]];
        }
        boolean notTake = dp[index-1][target];
        dp[index][target] = take || notTake;
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < sum+1; i++) {
      if(dp[m-1][i]){
        int part1 = i;
        int part2 = sum - i;
        int diff = Math.abs(part1 - part2);
        if(diff < min){
          min = diff;
        }
      }
    }
    return min;

  }
}

//for -negative numbers this will work
class Solution_meetAtMiddle {

  public int minimumDifference(int[] nums) {

    int N = nums.length;
    int res = Integer.MAX_VALUE; // Change this to Integer.MAX_VALUE
    int sum = Arrays.stream(nums).sum();
    int n = N / 2;
    List<List<Integer>> left = new ArrayList<>();
    List<List<Integer>> right = new ArrayList<>();

    // Initialize lists for storing subset sums by size
    for (int i = 0; i <= n; i++) {
      left.add(new ArrayList<>());
      right.add(new ArrayList<>());
    }

    // Storing all possible subset sums in left and right halves
    for (int mask = 0; mask < (1 << n); mask++) {
      int size = 0;
      int l = 0;
      int r = 0;
      for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0) {
          size++;
          l += nums[i];
          r += nums[i + n];
        }
      }
      left.get(size).add(l);
      right.get(size).add(r);
    }

    // Sort right lists for binary search
    for (int i = 0; i < n; i++) {
      Collections.sort(right.get(i));
    }

    // Target to balance the sums
    int halfSum = sum / 2;

    // Now check for the minimum difference
    for (int i = 0; i <= n; i++) {
      for (int a : left.get(i)) {
        int b = halfSum - a;
        int remainSize = n - i;
        List<Integer> rightHalf = right.get(remainSize);

        // Binary search for the closest sum
        int lowerBound = Collections.binarySearch(rightHalf, b);
        if (lowerBound < 0) {
          lowerBound = -(lowerBound + 1);
        }

        // Check the value at lowerBound
        if (lowerBound < rightHalf.size()) {
          int r = rightHalf.get(lowerBound);
          int diff = Math.abs((a + r) - (sum - a - r));
          res = Math.min(res, diff);
        }

        // Check the value before lowerBound (if valid)
        if (lowerBound > 0) {
          int r = rightHalf.get(lowerBound - 1);
          int diff = Math.abs((a + r) - (sum - a - r));
          res = Math.min(res, diff);
        }
      }
    }

    return res;
  }
}

