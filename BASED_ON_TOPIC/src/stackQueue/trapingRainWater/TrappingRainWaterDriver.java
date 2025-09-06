package stackQueue.trapingRainWater;

public class TrappingRainWaterDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}

class Solution {
  public int trap(int[] height) {


    int[] preBig = new int[height.length];
    int[] nextBig = new int[height.length];

    int big = -1;
    for (int i = 0; i < height.length; i++) {
      preBig[i] = big;
      big = Math.max(big,height[i]);
    }

    big = -1;
    for (int i = height.length-1 ; i >= 0; i--) {
      nextBig[i] = big;
      big = Math.max(big,height[i]);
    }

    int sum =0;
    for (int i = 0; i < height.length; i++) {
      int waterOnI = Math.min(preBig[i],nextBig[i])-height[i];
      sum += Math.max(waterOnI, 0);
    }
    return sum;

  }
}