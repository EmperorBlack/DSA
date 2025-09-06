package stackQueue.maxSlideWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class MaxSlidWindowDriver {

  public static void main(String[] args) {

    System.out.println(
        Arrays.toString(new Solution().maxSlidingWindow(new int[]{1}, 1)));
  }
}

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {

    int[] result = new int[(nums.length-k)+1];

    Deque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {

      if(i < k-1){

        while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
          queue.pollLast();
        }
        queue.offer(i);

      }else{
        while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
          queue.pollLast();
        }
        queue.offer(i);

        if(queue.peek() <= (i-k)){
          queue.poll();
        }

        result[(i-k)+1] = nums[queue.peek()];

      }

    }

    return result;

  }
}


