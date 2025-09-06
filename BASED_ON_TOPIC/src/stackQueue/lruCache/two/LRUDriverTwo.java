package stackQueue.lruCache.two;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUDriverTwo {

  public static void main(String[] args) {

    LRUCache cache = new LRUCache(2);
    cache.put(2,1);
    cache.put(3,2);
    System.out.println(cache.get(3));
    System.out.println(cache.get(2));
    cache.put(4,3);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));

  }
}
class LRUCache {

  Map<Integer,Integer> map = new HashMap<>();
  LinkedHashSet<Integer> set = new LinkedHashSet<>();
  int capacity = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {

    if(!map.containsKey(key)){
      return -1;
    }
    set.remove(key);
    set.add(key);
    return map.get(key);
  }

  public void put(int key, int value) {

    if(map.containsKey(key)){
        map.put(key,value);
        set.remove(key);
        set.add(key);
    }else {
      if(set.size() == capacity){
        Integer node  = set.iterator().next();
        map.remove(node);
        set.remove(node);
      }
      map.put(key,value);
      set.add(key);
    }

  }
}