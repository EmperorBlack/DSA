package heap.topKFrequent;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentDriver {

  public static void main(String[] args) {

  }
}

class Pair{
  int num;
  int frq;

  public Pair(int num, int frq) {
    this.num = num;
    this.frq = frq;
  }
}
class Solution {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer,Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num,map.getOrDefault(num,0)+1);
    }

    Queue<Pair> queue = new PriorityQueue<>((p1,p2)->Integer.compare(p1.frq,p2.frq));
    for (Map.Entry<Integer,Integer> entry : map.entrySet()){
      queue.offer(new Pair(entry.getKey(),entry.getValue()));
      if(queue.size() > k){
        queue.poll();
      }
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = queue.poll().num;
    }
    return result;
  }
}
