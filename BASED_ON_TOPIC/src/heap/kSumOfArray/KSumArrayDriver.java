package heap.kSumOfArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KSumArrayDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().kSum(new int[]{2,4,-2},5));
  }
}

class Pair{
  int index;
  long sum;
  boolean isDuplicate;

  public Pair(int index, long sum, boolean isDuplicate) {
    this.index = index;
    this.sum = sum;
    this.isDuplicate = isDuplicate;
  }
}
class Solution {
  public long kSum(int[] nums, int k) {

    Queue<Pair> queue = new PriorityQueue<>((p1,p2)-> Long.compare(p2.sum,p1.sum));

    long maxSumSeq = 0;
    for (int i = 0; i < nums.length; i++) {

      if(nums[i] >0){
        maxSumSeq += nums[i];
      }else{
        nums[i] =Math.abs(nums[i]);
      }
    }

    Arrays.sort(nums);
    List<Long> list = new ArrayList<>();
    list.add(maxSumSeq);
    queue.offer(new Pair(0,maxSumSeq-nums[0],false));
    while (!queue.isEmpty() && list.size() <= k){

      Pair p = queue.poll();
        list.add(p.sum);


      if(p.index < nums.length){

        queue.offer(new Pair(p.index+1,p.sum - nums[p.index+1], false));
        queue.offer(new Pair(p.index+1,p.sum + nums[p.index] - nums[p.index+1], true));

      }




    }

    return list.get(k-1);
  }
}