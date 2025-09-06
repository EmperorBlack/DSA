package stackQueue.revelCard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RevelCardDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int[] deckRevealedIncreasing(int[] deck) {

    Arrays.sort(deck);
    int ansIndex =0 ;
    int[] ans = new int[deck.length];

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < deck.length; i++) {
      queue.offer(i);
    }

    while (!queue.isEmpty()){

      int ind = queue.poll();
      ans[ind] = deck[ansIndex++];
      if(!queue.isEmpty())
        queue.offer(queue.poll());
    }

    return ans;
  }
}
