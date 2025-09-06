package google.numberOfSeqCondition;

import java.util.Arrays;
import java.util.stream.Stream;

public class NumberOfSequenceConditionDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().numSubseq(new int[]{3,5,6,7}, 9));
  }
}

class Solution {
  public int numSubseq(int[] nums, int target) {

    Arrays.sort(nums); // Sorting is mandatory to make min/max comparisons meaningful
    int n = nums.length;
    int[] pow = new int[n];
    int MOD = 1_000_000_007;
    pow[0] = 1;

    for (int i = 1; i < n ; i++) {
      pow[i] = (pow[i-1] * 2) % MOD; // Precompute powers of 2
    }

    int count = 0;
    int left = 0;
    int right = n - 1;

    while (left <= right){

      int sum = nums[left] + nums[right];
      if(sum <= target){
        int len = right - left;
        count += pow[len] % MOD;
        count %= MOD; // Ensure count is within MOD
        left++; // Move left pointer to the right

      }else {
        right--;
      }

    }

    return count;
  }
}




class Solution_3 {
  private static final int MOD = 1_000_000_007;

  public int numSubseq(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    int count = 0;

    // Precompute powers of 2
    int[] pow2 = new int[n];
    pow2[0] = 1;
    for (int i = 1; i < n; i++) {
      pow2[i] = (pow2[i - 1] * 2) % MOD;
    }

    for (int i = 0; i < n; i++) {
      int min = nums[i];
      int maxIndex = numSubBSearch(nums, target - min, i, n - 1);

      if (maxIndex >= i) {
        int len = maxIndex - i;
        count = (count + pow2[len]) % MOD;
      }
    }

    return count;
  }

  private int numSubBSearch(int[] nums, int target, int left, int right) {
    int res = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] <= target) {
        res = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return res;
  }
}







































class Solution_2 {

  private static final int MOD = 1_000_000_007;

  int maxValueO = 0;
  int minValueO = 0;
  public int numSubseq(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

//    Arrays.sort(nums);  // Sorting is mandatory to make min/max comparisons meaningful

//    int maxValue = nums[nums.length - 1];  // already sorted
    maxValueO = Stream.of(nums).flatMapToInt(Arrays::stream).max().orElse(0); // Find the maximum value in the array
    minValueO   = Stream.of(nums).flatMapToInt(Arrays::stream).min().orElse(0); // Find the minimum value in the array
    int[][][] dp = new int[nums.length][maxValueO + 1][maxValueO + 1];

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j <= maxValueO; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    return numSubSeqHelper(nums, target, nums.length - 1, maxValueO, minValueO, dp);
  }

  private int numSubSeqHelper(int[] nums, int target, int index, int min, int max, int[][][] dp) {
    if (index < 0) {

      if(min == maxValueO && max == minValueO){
        return 0; // No valid subsequence
      }
      return (min + max <= target) ? 1 : 0;
    }

    if (dp[index][min][max] != -1) {
      return dp[index][min][max];
    }

    // Exclude nums[index]
    int notChoose = numSubSeqHelper(nums, target, index - 1, min, max, dp);

    // Include nums[index]
    int newMin = Math.min(min, nums[index]);
    int newMax = Math.max(max, nums[index]);

    int choose = numSubSeqHelper(nums, target, index - 1, newMin, newMax, dp);

    int res = (choose + notChoose) % MOD;
    dp[index][min][max] = res;
    return res;
  }
}
