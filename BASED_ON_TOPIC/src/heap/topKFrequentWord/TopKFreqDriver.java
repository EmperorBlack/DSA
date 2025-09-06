package heap.topKFrequentWord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class TopKFreqDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().topKFrequent(new String[]{"i","love","leetcode","i","love","coding"},2));
  }
}

class Solution {
  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> map = new HashMap<>();
    Map<Integer, TreeSet<String>> freqToString = new HashMap<>();
    Queue<Entry<Integer,TreeSet<String>>> queue = new PriorityQueue<>((entry1,entry2)->Integer.compare(entry2.getKey(),entry1.getKey()));

    for(String word: words){
      map.put(word,map.getOrDefault(word,0)+1);
    }

    for(Map.Entry<String,Integer> entry : map.entrySet()){
      TreeSet<String> keys = freqToString.getOrDefault(entry.getValue(),new TreeSet<>());
      keys.add(entry.getKey());
      freqToString.put(entry.getValue(),keys);
    }

    for(Map.Entry<Integer, TreeSet<String>> entry : freqToString.entrySet()){
      queue.offer(entry);
    }

    List<String> result = new ArrayList<>();
    while(k>0 && !freqToString.isEmpty()){

      for(String set : queue.poll().getValue()){
        result.add(set);
        k--;
        if(k <= 0){
          break;
        }
      }

    }
    return result;


  }
}

class Solution_2 {
  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> map = new HashMap<>();
    Queue<Entry<String,Integer>> queue = new PriorityQueue<>(
        new Comparator<Entry<String, Integer>>() {
          @Override
          public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            if(o1.getValue() != o2.getValue()){
              return Integer.compare(o2.getValue(),o1.getValue());
            }else{
              return o1.getKey().compareTo(o2.getKey());
            }
          }
        });

    for(String word: words){
      map.put(word,map.getOrDefault(word,0)+1);
    }

    for(Map.Entry<String,Integer> entry : map.entrySet()){
      queue.offer(entry);
    }


    List<String> result = new ArrayList<>();
    while(k>0 && !queue.isEmpty()){
      result.add(queue.poll().getKey());
      k--;
    }
    return result;



  }
}