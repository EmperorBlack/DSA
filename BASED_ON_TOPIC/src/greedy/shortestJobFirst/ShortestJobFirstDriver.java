package greedy.shortestJobFirst;

import java.util.Arrays;

public class ShortestJobFirstDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  static int solve(int bt[] ) {
    // code here

    Arrays.sort(bt);
    int waitingTimeSum = 0;
    int waitingTimeAtI = 0;
    for (int i = 0; i < bt.length; i++) {

      waitingTimeSum = waitingTimeSum+waitingTimeAtI;
      waitingTimeAtI = waitingTimeAtI + bt[i];

    }
    return waitingTimeSum/ bt.length;
  }
}

