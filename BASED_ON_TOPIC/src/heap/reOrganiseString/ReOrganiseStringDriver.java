package heap.reOrganiseString;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReOrganiseStringDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public String reorganizeString(String s) {

    Map<Character,Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c,map.getOrDefault(c,0)+1);
    }

    Queue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((e1,e2)-> Integer.compare(e2.getValue(),e1.getValue()));
    for (Map.Entry<Character,Integer> entry : map.entrySet()) {
      queue.offer(entry);
    }

    Entry<Character,Integer> pre = null;
    StringBuilder result = new StringBuilder();
    while (!queue.isEmpty()){

      Entry<Character,Integer> curr = queue.poll();
      result.append(curr.getKey());
      curr.setValue(curr.getValue()-1);
      if(pre != null && pre.getValue() > 0){
        queue.offer(pre);
      }
      pre = curr;

    }

    return result.length() == s.length() ? result.toString() : "";

  }
}


