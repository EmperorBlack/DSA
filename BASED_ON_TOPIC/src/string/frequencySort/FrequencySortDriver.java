package string.frequencySort;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySortDriver {

  public static void main(String[] args) {

  }
}


class Solution {

  class Pair{
    char c;
    int freq;

    public Pair(char c, int freq) {
      this.c = c;
      this.freq = freq;
    }
  }

  public String frequencySort(String s) {

    Queue<Pair> queue = new PriorityQueue<>((p1,p2)->Integer.compare(p2.freq,p1.freq));
    Map<Character,Integer> map = new HashMap<>();
    for (int i = 0; i <s.length() ; i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
    }

    for (Map.Entry<Character,Integer> keyValue :map.entrySet()){
      queue.offer(new Pair(keyValue.getKey(),keyValue.getValue()));
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()){

      Pair p = queue.poll();
      String temp = String.valueOf(p.c).repeat(p.freq);
      sb.append(temp);

    }
    return sb.toString();

  }
}
