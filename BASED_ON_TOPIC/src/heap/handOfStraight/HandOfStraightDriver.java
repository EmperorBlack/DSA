package heap.handOfStraight;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class HandOfStraightDriver {

}

//Heap solution
class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {

    if(hand.length % groupSize != 0){
      return false;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Queue<Integer> queue = new ArrayDeque<>();

    for(int hnd : hand){
      pq.offer(hnd);
    }

    while(!pq.isEmpty()){

      int count =0;
      int pre = -1;
      while(!pq.isEmpty() && count < groupSize){
        if(pre!=pq.peek() && (pre == -1 || pre+1 == pq.peek())){
          pre = pq.poll();
          count++;
        }else {
          queue.offer(pq.poll());
        }
      }

      if(count != groupSize){
        return false;
      }

      pq.addAll(queue);
      queue.clear();
    }
    return true;
  }
}

//TreeMap solution
class Solution_1 {
  public boolean isNStraightHand(int[] hand, int groupSize) {

    TreeMap<Integer,Integer> map = new TreeMap<>();
    for (int hnd : hand){
      map.put(hnd,map.getOrDefault(hnd,0)+1);
    }

    while (!map.isEmpty()){

      int count = 1;
      int key = map.firstKey();
      map.put(key,map.get(key)-1);
      if(map.get(key) ==0){
        map.remove(key);
      }

      while (!map.isEmpty() && count < groupSize){
        key = key+1;
        if(!map.containsKey(key)){
          return false;
        }else{
          count++;
          map.put(key, map.get(key)-1);
          if(map.get(key) == 0){
            map.remove(key);
          }
        }
      }
      if(count != groupSize){
        return false;
      }
    }
    return true;
  }
}
