package heap.kLargestElement;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElementDriver {

}


class Solution {
  public int findKthLargest(int[] nums, int k) {

    Queue<Integer> queue = new PriorityQueue<>((a,b)->Integer.compare(b,a));

    for (int i = 0; i < nums.length; i++) {
      queue.offer(nums[i]);
      if(queue.size() > k){
        queue.poll();
      }
    }
    return queue.peek();

  }
}

class KthLargest {

  Queue<Integer> queue = new PriorityQueue<>();
  int k = 0;
  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (int num : nums){
      queue.offer(num);
      if(queue.size() > k){
        queue.poll();
      }
    }
  }

  public int add(int val) {
    queue.offer(val);
    if(queue.size() > k){
      queue.poll();
    }
    if(!queue.isEmpty()){
      return queue.peek();
    }
    return 0;
  }
}